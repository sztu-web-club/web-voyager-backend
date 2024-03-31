package io.github.sztuwebclub.webvoyager.domain.solution;

import java.util.List;

public interface ISolutionRepo {
    Integer solutionCount(Integer problemId, Integer contestId, Integer userId);

    List<Solution> pageQuery(Integer start, Integer pagesize, Integer problemId, Integer contestId, Integer userId);
}
