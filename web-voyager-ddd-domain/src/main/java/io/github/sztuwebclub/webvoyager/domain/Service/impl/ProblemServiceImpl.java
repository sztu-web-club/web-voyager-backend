package io.github.sztuwebclub.webvoyager.domain.Service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.github.sztuwebclub.webvoyager.constant.model.PageResult;
import io.github.sztuwebclub.webvoyager.domain.Service.ProblemService;
import io.github.sztuwebclub.webvoyager.domain.problem.IProblemRepo;
import io.github.sztuwebclub.webvoyager.domain.problem.Problem;
import io.github.sztuwebclub.webvoyager.domain.problem.ProblemDetails;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProblemServiceImpl implements ProblemService {
    @Resource
    private IProblemRepo problemRepo;

    @Override
    public PageResult<Problem> pageQuery(Integer page, Integer pagesize, String title) {
        Integer total = problemRepo.problemCount(title);
        Integer start = (page - 1)*pagesize + 1;
        List<Problem> resultList = problemRepo.pageQuery(start, pagesize, title);
        return new PageResult(total, start, pagesize, resultList);
    }

    @Override
    public Problem getProblemById(Integer id) {
        return problemRepo.getProblemById(id);
    }

    @Override
    public ProblemDetails getProblemDetailsById(Integer id) {
        return problemRepo.getProblemDeatilsById(id);
    }
}
