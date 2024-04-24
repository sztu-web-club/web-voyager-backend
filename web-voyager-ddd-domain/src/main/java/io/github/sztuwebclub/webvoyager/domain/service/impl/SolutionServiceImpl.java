package io.github.sztuwebclub.webvoyager.domain.service.impl;

import io.github.sztuwebclub.webvoyager.constant.model.PageResult;
import io.github.sztuwebclub.webvoyager.domain.service.ISolutionService;
import io.github.sztuwebclub.webvoyager.domain.solution.ISolutionRepo;
import io.github.sztuwebclub.webvoyager.domain.solution.Solution;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;

@Service
public class SolutionServiceImpl implements ISolutionService {
    @Resource
    private ISolutionRepo solutionRepo;

    private final ConcurrentHashMap<SseEmitter, ScheduledExecutorService> emitterSchedulers = new ConcurrentHashMap<>();
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
                                          Integer pageSize,
                                          Integer problemId,
                                          Integer contestId,
                                          Integer userId) {
        Solution solution = Solution.builder()
                .problemid(problemId)
                .contestid(contestId)
                .userid(userId)
                .build();
        return solution.pageQuery(page,pageSize,solutionRepo);
    }


    @Override
    public SseEmitter streamSolutionPageWithSSE(Integer page,
                                                Integer pageSize,
                                                Integer problemId,
                                                Integer contestId,
                                                Integer userId) {
        Solution solution = Solution.builder()
                .problemid(problemId)
                .contestid(contestId)
                .userid(userId)
                .build();
        return solution.streamSolutionPageWithSSE(page,pageSize,emitterSchedulers,solutionRepo);
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
        Solution solution = Solution.builder()
                .id(Long.valueOf(id))
                .build();
        return solution.streamSolutionWithSSE(emitterSchedulers,solutionRepo);
    }
}
