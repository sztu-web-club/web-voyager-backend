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
        return Problem.pageQuery(page,pagesize,title,problemRepo);
    }

    @Override
    public Problem getProblemById(Integer id) {
        return Problem.getPrblemById(id,problemRepo);
    }

    @Override
    public ProblemDetails getProblemDetailsById(Integer id) {
        return problemRepo.getProblemDeatilsById(id);
    }
}
