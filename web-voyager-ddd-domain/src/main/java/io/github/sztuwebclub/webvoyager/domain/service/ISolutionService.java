package io.github.sztuwebclub.webvoyager.domain.service;

import io.github.sztuwebclub.webvoyager.constant.model.PageResult;
import io.github.sztuwebclub.webvoyager.domain.solution.Solution;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

public interface ISolutionService {
    void submit(Solution solution);

    PageResult<Solution> pageQuery(Integer page,
                                   Integer pagesize,
                                   Integer problemId,
                                   Integer contestId,
                                   Integer userId);

    SseEmitter streamSolutionsWithSSE(Integer page,
                                      Integer pageSize,
                                      Integer problemId,
                                      Integer contestId,
                                      Integer userId);

}
