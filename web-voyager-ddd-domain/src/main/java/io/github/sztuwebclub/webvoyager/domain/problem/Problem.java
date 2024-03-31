package io.github.sztuwebclub.webvoyager.domain.problem;

import io.github.sztuwebclub.webvoyager.constant.AuditableEntity;
import io.github.sztuwebclub.webvoyager.constant.model.PageResult;
import jakarta.annotation.Resource;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
public class Problem extends AuditableEntity implements Serializable {
    private Long id;
    private String title;
    private Double timeLimit;
    private Integer memoryLimit;
    private Integer totalSolved;
    private Integer totalSubmit;
    private Integer authorId;
    private String authorName;

    public PageResult<Problem> pageQuery(Integer page, Integer pagesize, IProblemRepo problemRepo) {
        Integer total = problemRepo.problemCount(title);
        Integer start = (page - 1)*pagesize;
        List<Problem> resultList = problemRepo.pageQuery(start, pagesize, title);
        return new PageResult<>(total, start + 1, pagesize, resultList);
    }

    public Problem getPrblemById(IProblemRepo problemRepo) {
        return problemRepo.getProblemById(id);
    }
}
