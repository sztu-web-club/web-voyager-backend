package io.github.sztuwebclub.webvoyager.domain.problem;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.util.List;

public interface IProblemRepo {
    Integer problemCount(String title);

    List<Problem> pageQuery(Integer page, Integer pagesize, String title);

    Problem getProblemById(Integer id);

    ProblemDetails getProblemDeatilsById(Integer id);
}
