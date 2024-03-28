package io.github.sztuwebclub.webvoyager.domain.Service.impl;

import io.github.sztuwebclub.webvoyager.domain.Service.SolutionService;
import io.github.sztuwebclub.webvoyager.domain.solution.ISolutionRepo;
import io.github.sztuwebclub.webvoyager.domain.solution.Solution;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class SolutionServiceImpl implements SolutionService {
    @Resource
    private ISolutionRepo solutionRepo;

    @Override
    public void submit(Solution solution) {
        solution.submit();
    }
}
