package io.github.sztuwebclub.webvoyager.domain.solution;

import io.github.sztuwebclub.webvoyager.constant.AuditableEntity;
import io.github.sztuwebclub.webvoyager.constant.model.PageResult;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.List;

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
}
