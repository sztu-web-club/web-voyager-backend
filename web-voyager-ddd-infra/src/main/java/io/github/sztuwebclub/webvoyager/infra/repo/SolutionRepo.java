package io.github.sztuwebclub.webvoyager.infra.repo;

import io.github.sztuwebclub.webvoyager.domain.solution.ISolutionRepo;
import io.github.sztuwebclub.webvoyager.infra.dao.SolutionMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository
public class SolutionRepo implements ISolutionRepo {
    @Resource
    private SolutionMapper solutionDao;
}
