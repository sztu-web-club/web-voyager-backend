package io.github.sztuwebclub.webvoyager.domain.service;

import io.github.sztuwebclub.webvoyager.constant.model.PageResult;
import io.github.sztuwebclub.webvoyager.domain.solution.Solution;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

public interface ISolutionService {
    void submit(Integer problemId,
                Integer userId,
                Integer contestId,
                String language,
                String code);

    PageResult<Solution> pageQuery(Integer page,
                                   Integer pagesize,
                                   Integer problemId,
                                   Integer contestId,
                                   Integer userId);

    SseEmitter streamSolutionPageWithSSE(Integer page,
                                      Integer pageSize,
                                      Integer problemId,
                                      Integer contestId,
                                      Integer userId);

    Solution getSolutionById(Integer id);

    SseEmitter streamSolutionWithSSE(Integer id);
}
