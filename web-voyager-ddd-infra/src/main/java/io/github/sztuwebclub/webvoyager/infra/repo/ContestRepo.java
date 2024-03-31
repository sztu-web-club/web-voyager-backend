package io.github.sztuwebclub.webvoyager.infra.repo;

import io.github.sztuwebclub.webvoyager.domain.contest.Contest;
import io.github.sztuwebclub.webvoyager.domain.contest.ContestProblem;
import io.github.sztuwebclub.webvoyager.domain.contest.IContestRepo;
import io.github.sztuwebclub.webvoyager.infra.dao.ContestMapper;
import io.github.sztuwebclub.webvoyager.infra.dao.ContestProblemMapper;
import io.github.sztuwebclub.webvoyager.infra.po.ContestPO;
import io.github.sztuwebclub.webvoyager.infra.po.ContestProblemPO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class ContestRepo implements IContestRepo {
    @Resource
    private ContestMapper contestDao;

    @Resource
    private ContestProblemMapper contestProblemDao;

    @Override
    public Integer contestCount(String name) {
        return contestDao.contestCount(name);
    }

    @Override
    public List<Contest> pageQuery(Integer start, Integer pagesize, String name) {
        return contestDao.pageQuery(start,pagesize,name);
    }

    @Override
    public Contest getContestById(Long id) {
        return contestDao.getContestById(id);
    }

    @Override
    public Contest getContestByName(String name) {
        return contestDao.getContestByName(name);
    }

    @Override
    public List<ContestProblem> getContestProblemListByContestId(Integer contestid) {
        return contestProblemDao.getContestProblemListByContestId(contestid);
    }

    @Override
    public void creatContest(String name, Date starttime, Date endtime, String desp) {
        ContestPO contestPO = new ContestPO();

        contestPO.setName(name);
        contestPO.setStartTime(starttime);
        contestPO.setEndTime(endtime);
        contestPO.setDescription(desp);

        contestDao.insert(contestPO);
    }

    @Override
    public void creatContestProblem(List<ContestProblem> contestProblemList, IContestRepo contestRepo) {
        for (ContestProblem contestProblem : contestProblemList){
            ContestProblemPO contestProblemPO = new ContestProblemPO();

            contestProblemPO.setContestId(contestProblem.getContestid());
            contestProblemPO.setProblemId(contestProblem.getProblemid());
            contestProblemPO.setSequence(contestProblem.getSequence());
            contestProblemPO.setTitle(contestProblem.getTitle());

            contestProblemDao.insert(contestProblemPO);
        }
    }
}
