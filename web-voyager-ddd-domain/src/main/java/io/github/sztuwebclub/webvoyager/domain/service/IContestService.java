package io.github.sztuwebclub.webvoyager.domain.service;

import io.github.sztuwebclub.webvoyager.constant.model.PageResult;
import io.github.sztuwebclub.webvoyager.domain.contest.Contest;
import io.github.sztuwebclub.webvoyager.domain.contest.ContestProblem;

import java.util.Date;
import java.util.List;

public interface IContestService {
    void creatContest(String name, Date starttime, Date endtime, String desp, List<ContestProblem> contestProblemList);

    PageResult<Contest> pageQuery(Integer page, Integer pagesize, String name);

    Contest getContestById(Integer id);

    List<ContestProblem> getContestProblemListByContestId(Integer id);

}
