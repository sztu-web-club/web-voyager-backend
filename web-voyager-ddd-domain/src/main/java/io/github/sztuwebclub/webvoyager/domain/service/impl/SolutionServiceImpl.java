package io.github.sztuwebclub.webvoyager.domain.service.impl;

import io.github.sztuwebclub.webvoyager.constant.model.PageResult;
import io.github.sztuwebclub.webvoyager.domain.service.ISolutionService;
import io.github.sztuwebclub.webvoyager.domain.solution.ISolutionRepo;
import io.github.sztuwebclub.webvoyager.domain.solution.Solution;
import io.github.sztuwebclub.webvoyager.domain.user.User;
import jakarta.annotation.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class SolutionServiceImpl implements ISolutionService {
    @Resource
    private ISolutionRepo solutionRepo;

    private ConcurrentHashMap<SseEmitter, ScheduledExecutorService> emitterSchedulers = new ConcurrentHashMap<>();
    @Override
    public void submit(Integer problemId, Integer userId, Integer contestId, String language, String code) {
        Solution solution = Solution.builder()
                .problemid(problemId)
                .userid(userId)
                .contestid(contestId)
                .language(language)
                .code(code)
                .build();
        solution.submit(solutionRepo);
    }

    @Override
    public PageResult<Solution> pageQuery(Integer page,
                                          Integer pagesize,
                                          Integer problemId,
                                          Integer contestId,
                                          Integer userId) {
        Solution solution = Solution.builder()
                .problemid(problemId)
                .contestid(contestId)
                .userid(userId)
                .build();
        return solution.pageQuery(page,pagesize,solutionRepo);
    }


    @Override
    public SseEmitter streamSolutionPageWithSSE(Integer page, Integer pageSize, Integer problemId, Integer contestId, Integer userId) {
        SseEmitter emitter = new SseEmitter();

        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        emitterSchedulers.put(emitter, scheduler);

        scheduler.scheduleAtFixedRate(() -> {
            try {
                PageResult<Solution> pageResult = pageQuery(page, pageSize, problemId, contestId, userId);

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

    @Override
    public Solution getSolutionById(Integer id) {
        Solution solution = Solution.builder()
                .id(Long.valueOf(id))
                .build();
        return solution.getSolutionById(solutionRepo);
    }

    @Override
    public SseEmitter streamSolutionWithSSE(Integer id) {
        SseEmitter emitter = new SseEmitter();

        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        emitterSchedulers.put(emitter, scheduler);

        scheduler.scheduleAtFixedRate(() -> {
            try {
                Solution solution = getSolutionById(id);

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
}
