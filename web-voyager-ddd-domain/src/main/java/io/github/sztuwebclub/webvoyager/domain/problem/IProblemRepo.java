package io.github.sztuwebclub.webvoyager.domain.problem;

import java.util.List;

public interface IProblemRepo {
    Integer problemCount(String title);

    List<Problem> pageQuery(Integer page, Integer pagesize, String title);

    Problem getProblemById(Long id);

    ProblemDetails getProblemDeatilsById(Long id);
}
