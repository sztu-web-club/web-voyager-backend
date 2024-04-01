package io.github.sztuwebclub.webvoyager.domain.solution;

import io.github.sztuwebclub.webvoyager.constant.AuditableEntity;
import io.github.sztuwebclub.webvoyager.constant.model.PageResult;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
        Integer start = (page - 1)*pagesize;
        List<Solution> resultList = solutionRepo.pageQuery(start, pagesize, problemid,contestid,userid);
        return new PageResult<>(total, start + 1, pagesize, resultList);
    }

    public void submit() {
        //TODO 调用沙箱判题和保存
    }
}
