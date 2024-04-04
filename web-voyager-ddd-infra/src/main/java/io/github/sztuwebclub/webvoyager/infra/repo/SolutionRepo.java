package io.github.sztuwebclub.webvoyager.infra.repo;

import io.github.sztuwebclub.webvoyager.domain.solution.ISolutionRepo;
import io.github.sztuwebclub.webvoyager.domain.solution.Solution;
import io.github.sztuwebclub.webvoyager.infra.dao.SolutionMapper;
import io.github.sztuwebclub.webvoyager.infra.po.SolutionPO;
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

    @Override
    public Long submitUnJudgedSolution(Integer problemid, Integer userid, Integer contestid, String language, String code) {
        SolutionPO solutionPO = new SolutionPO();

        solutionPO.setProblemId(problemid);
        solutionPO.setUserId(userid);
        solutionPO.setContestId(contestid);
        solutionPO.setLanguage(language);
        solutionPO.setCode(code);
        solutionPO.setTime(-1);
        solutionPO.setMemory(-1);
        solutionPO.setResult(0);
        solutionPO.setPassedTest(-1);
        solutionPO.setTotalTest(-1);
        solutionPO.setJudgerId(-1);

        solutionDao.insert(solutionPO);
        return solutionPO.getId();
    }

    @Override
    public void upDataJudgedMessageById(Long id, Integer time, Integer memory, Integer result, Integer passedtest, Integer totaltest, Integer judgerid) {
        SolutionPO solutionPO = new SolutionPO();
        solutionPO.setId(id);
        solutionPO.setTime(time);
        solutionPO.setMemory(memory);
        solutionPO.setResult(result);
        solutionPO.setPassedTest(passedtest);
        solutionPO.setTotalTest(totaltest);
        solutionPO.setJudgerId(judgerid);

        solutionDao.updateById(solutionPO);
    }
}
