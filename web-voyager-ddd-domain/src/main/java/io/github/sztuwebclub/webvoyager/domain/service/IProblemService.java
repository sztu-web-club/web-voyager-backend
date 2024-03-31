package io.github.sztuwebclub.webvoyager.domain.service;

import io.github.sztuwebclub.webvoyager.constant.model.PageResult;
import io.github.sztuwebclub.webvoyager.domain.problem.Problem;
import io.github.sztuwebclub.webvoyager.domain.problem.ProblemDetails;

public interface IProblemService {

    PageResult<Problem> pageQuery(Integer page, Integer pagesize, String title);

    Problem getProblemById(Integer id);

    ProblemDetails getProblemDetailsById(Integer id);
}
