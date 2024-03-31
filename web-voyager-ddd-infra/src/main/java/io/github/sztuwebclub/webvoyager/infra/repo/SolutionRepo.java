package io.github.sztuwebclub.webvoyager.infra.repo;

import io.github.sztuwebclub.webvoyager.domain.solution.ISolutionRepo;
import io.github.sztuwebclub.webvoyager.domain.solution.Solution;
import io.github.sztuwebclub.webvoyager.infra.dao.SolutionMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SolutionRepo implements ISolutionRepo {
    @Resource
    private SolutionMapper solutionDao;

    @Override
    public Integer solutionCount(Integer problemId, Integer contestId, Integer userId) {
        return solutionDao.solutionCount(problemId,contestId,userId);
    }

    @Override
    public List<Solution> pageQuery(Integer start, Integer pagesize, Integer problemId, Integer contestId, Integer userId) {
        return solutionDao.pageQuery(start,pagesize,problemId,contestId,userId);
    }
}
