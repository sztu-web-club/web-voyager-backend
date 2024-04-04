package io.github.sztuwebclub.webvoyager.domain.solution;

import java.util.List;

public interface ISolutionRepo {
    Integer solutionCount(Integer problemId, Integer contestId, Integer userId);

    List<Solution> pageQuery(Integer start, Integer pagesize, Integer problemId, Integer contestId, Integer userId);

    Long submitUnJudgedSolution(Integer problemid, Integer userid, Integer contestid, String language, String code);

    void upDataJudgedMessageById(Long id, Integer time, Integer memory, Integer result, Integer passedtest, Integer totaltest, Integer judgerid);
}
