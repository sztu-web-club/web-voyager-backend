package io.github.sztuwebclub.webvoyager.domain.service.impl;

import io.github.sztuwebclub.webvoyager.constant.model.PageResult;
import io.github.sztuwebclub.webvoyager.domain.service.IProblemService;
import io.github.sztuwebclub.webvoyager.domain.problem.IProblemRepo;
import io.github.sztuwebclub.webvoyager.domain.problem.Problem;
import io.github.sztuwebclub.webvoyager.domain.problem.ProblemDetails;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ProblemServiceImpl implements IProblemService {
    @Resource
    private IProblemRepo problemRepo;

    @Override
    public PageResult<Problem> pageQuery(Integer page,
                                         Integer pagesize,
                                         String title) {
        Problem problem = Problem.builder()
                .title(title)
                .build();
        return problem.pageQuery(page,pagesize,problemRepo);
    }

    @Override
    public Problem getProblemById(Integer id) {
        Problem problem = Problem.builder()
                .id(Long.valueOf(id))
                .build();
        return problem.getPrblemById(problemRepo);
    }

    @Override
    public ProblemDetails getProblemDetailsById(Integer id) {
        ProblemDetails problemDetails = ProblemDetails.builder()
                .id(Long.valueOf(id))
                .build();
        return problemDetails.getProblemDeatilsById(problemRepo);
    }
}
