package io.github.sztuwebclub.webvoyager.domain.service.impl;

import io.github.sztuwebclub.webvoyager.constant.model.PageResult;
import io.github.sztuwebclub.webvoyager.domain.contest.Contest;
import io.github.sztuwebclub.webvoyager.domain.contest.ContestProblem;
import io.github.sztuwebclub.webvoyager.domain.contest.IContestRepo;
import io.github.sztuwebclub.webvoyager.domain.service.IContestService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ContestServiceImpl implements IContestService {
    @Resource
    private IContestRepo contestRepo;

    @Override
    @Transactional
    public void creatContest(String name,
                             Date starttime,
                             Date endtime,
                             String desp,
                             List<ContestProblem> contestProblemList) {
        Contest contest = Contest.builder()
                .name(name)
                .starttime(starttime)
                .endtime(endtime)
                .desp(desp)
                .build();

        contest.creatContest(contestRepo);

        ContestProblem contestProblem = ContestProblem.builder()
                .contestProblemList(contestProblemList)
                .build();
        contestProblem.setListId(Math.toIntExact(contest.getContestByName(contestRepo).getId()));
        contestProblem.creatContestProblem(contestRepo);
    }

    @Override
    public PageResult<Contest> pageQuery(Integer page,
                                         Integer pagesize,
                                         String name) {
        Contest contest = Contest.builder()
                .name(name)
                .build();
        return contest.pageQuery(page,pagesize,contestRepo);
    }

    @Override
    public Contest getContestById(Integer id) {
        Contest contest = Contest.builder()
                .id(Long.valueOf(id))
                .build();
        return contest.getContestById(contestRepo);
    }

    @Override
    public List<ContestProblem> getContestProblemListByContestId(Integer id) {
        ContestProblem contestProblem = ContestProblem.builder()
                .contestid(id)
                .build();
        return contestProblem.getContestProblemListById(contestRepo);
    }
}
