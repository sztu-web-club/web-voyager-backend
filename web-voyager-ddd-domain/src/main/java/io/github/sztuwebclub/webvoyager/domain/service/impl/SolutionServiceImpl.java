package io.github.sztuwebclub.webvoyager.domain.service.impl;

import io.github.sztuwebclub.webvoyager.constant.model.PageResult;
import io.github.sztuwebclub.webvoyager.domain.service.ISolutionService;
import io.github.sztuwebclub.webvoyager.domain.solution.ISolutionRepo;
import io.github.sztuwebclub.webvoyager.domain.solution.Solution;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class SolutionServiceImpl implements ISolutionService {
    @Resource
    private ISolutionRepo solutionRepo;

    @Override
    public void submit(Solution solution) {
        solution.submit();
    }

    @Override
    public PageResult<Solution> pageQuery(Integer page, Integer pagesize, Integer problemId, Integer contestId, Integer userId) {
        Solution solution = Solution.builder()
                .problemid(problemId)
                .contestid(contestId)
                .userid(userId)
                .build();
        return solution.pageQuery(page,pagesize,solutionRepo);
    }
}
