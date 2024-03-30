package io.github.sztuwebclub.webvoyager.infra.repo;

import io.github.sztuwebclub.webvoyager.domain.problem.IProblemRepo;
import io.github.sztuwebclub.webvoyager.domain.problem.Problem;
import io.github.sztuwebclub.webvoyager.domain.problem.ProblemDetails;
import io.github.sztuwebclub.webvoyager.infra.dao.ProblemDatailsMapper;
import io.github.sztuwebclub.webvoyager.infra.dao.ProblemMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProblemRepo implements IProblemRepo {
    @Resource
    private ProblemMapper problemDao;
    @Resource
    private ProblemDatailsMapper problemDatailsDao;

    @Override
    public Integer problemCount(String title) {
        return problemDao.problemCount(title);
    }

    @Override
    public List<Problem> pageQuery(Integer start, Integer pagesize, String title) {
        return problemDao.pageQuery(start,pagesize,title);
    }

    @Override
    public Problem getProblemById(Integer id) {
        return problemDao.getProblemById(id);
    }

    @Override
    public ProblemDetails getProblemDeatilsById(Integer id) {
        return problemDatailsDao.getProblemDeatilsById(id);
    }
}
