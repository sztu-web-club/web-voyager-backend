package io.github.sztuwebclub.webvoyager.domain.contest;

import java.util.Date;
import java.util.List;

public interface IContestRepo {
    Integer contestCount(String name);

    List<Contest> pageQuery(Integer start, Integer pagesize, String name);

    Contest getContestById(Long id);

    Contest getContestByName(String name);

    List<ContestProblem> getContestProblemListByContestId(Integer contestid);

    void creatContest(String name, Date starttime, Date endtime, String desp);

    void creatContestProblem(List<ContestProblem> contestProblemList, IContestRepo contestRepo);
}
