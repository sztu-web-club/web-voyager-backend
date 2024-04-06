package io.github.sztuwebclub.webvoyager.domain.solution;

import io.github.sztuwebclub.webvoyager.constant.AuditableEntity;
import io.github.sztuwebclub.webvoyager.constant.model.PageResult;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
public class Solution extends AuditableEntity implements Serializable {
    private Long id;
    private Integer problemid;
    private Integer userid;
    private Integer contestid;
    private Integer time;
    private Integer memory;
    private Integer result;
    private String language;
    private String code;
    private Integer passedtest;
    private Integer totaltest;
    private Integer judgerid;

    public PageResult<Solution> pageQuery(Integer page, Integer pagesize, ISolutionRepo solutionRepo) {
        Integer total = solutionRepo.solutionCount(problemid,contestid,userid);
        int start = (page - 1)*pagesize;
        List<Solution> resultList = solutionRepo.pageQuery(start, pagesize, problemid,contestid,userid);
        return new PageResult<>(total, start + 1, pagesize, resultList);
    }

    public void submit(ISolutionRepo solutionRepo) {
        //未判题预存储
        id = solutionRepo.submitUnJudgedSolution(problemid,userid,contestid,language,code);
        //TODO 调用沙箱判题(将判题结果相关成员变量保存到实例对象中)
        //判题结果更新
        solutionRepo.upDataJudgedMessageById(id,time,memory,result,passedtest,totaltest,judgerid);
    }

    public Solution getSolutionById(ISolutionRepo solutionRepo) {
        return solutionRepo.getUserById(id);
    }

    public SseEmitter streamSolutionWithSSE(ConcurrentMap<SseEmitter, ScheduledExecutorService> emitterSchedulers, ISolutionRepo solutionRepo) {
        SseEmitter emitter = new SseEmitter();

        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        emitterSchedulers.put(emitter, scheduler);

        scheduler.scheduleAtFixedRate(() -> {
            try {
                Solution solution = getSolutionById(solutionRepo);
                boolean success = solution.getResult()==0||solution.getResult()==1;
                if (!success) {
                    emitter.send(solution, MediaType.APPLICATION_JSON);
                } else {
                    emitter.send("All results are success", MediaType.TEXT_PLAIN);
                    emitter.send(solution, MediaType.APPLICATION_JSON);
                    emitter.complete();
                }
            } catch (Exception e) {
                emitter.completeWithError(e);
            }
        }, 0, 1, TimeUnit.SECONDS);

        emitter.onCompletion(() -> {
            ScheduledExecutorService scheduledExecutorService = emitterSchedulers.remove(emitter);
            scheduledExecutorService.shutdown();
        });

        return emitter;
    }

    public SseEmitter streamSolutionPageWithSSE(Integer page, Integer pageSize, ConcurrentMap<SseEmitter, ScheduledExecutorService> emitterSchedulers, ISolutionRepo solutionRepo) {
        SseEmitter emitter = new SseEmitter();

        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        emitterSchedulers.put(emitter, scheduler);

        scheduler.scheduleAtFixedRate(() -> {
            try {
                PageResult<Solution> pageResult = pageQuery(page, pageSize,solutionRepo);

                boolean allSuccess = pageResult.getList().stream().allMatch(solution -> solution.getResult() == 0 || solution.getResult() == 1);
                if (!allSuccess) {
                    emitter.send(pageResult, MediaType.APPLICATION_JSON);
                } else {
                    emitter.send("All results are success", MediaType.TEXT_PLAIN);
                    emitter.send(pageResult, MediaType.APPLICATION_JSON);
                    emitter.complete();
                }
            } catch (Exception e) {
                emitter.completeWithError(e);
            }
        }, 0, 1, TimeUnit.SECONDS);

        emitter.onCompletion(() -> {
            ScheduledExecutorService scheduledExecutorService = emitterSchedulers.remove(emitter);
            scheduledExecutorService.shutdown();
        });

        return emitter;
    }
}
