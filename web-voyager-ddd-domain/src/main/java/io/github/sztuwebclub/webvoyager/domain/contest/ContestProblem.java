package io.github.sztuwebclub.webvoyager.domain.contest;

import io.github.sztuwebclub.webvoyager.constant.AuditableEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
public class ContestProblem extends AuditableEntity{
    private Integer contestid;
    private Integer problemid;
    private Integer sequence;
    private String title;
    private List<ContestProblem> contestProblemList;

    public void creatContestProblem(IContestRepo contestRepo) {
        contestRepo.creatContestProblem(contestProblemList,contestRepo);
    }

    public void setListId(int id) {
        for (ContestProblem contestProblem : contestProblemList) {
            contestProblem.setContestid(id);
        }
    }

    public List<ContestProblem> getContestProblemListById(IContestRepo contestRepo) {
        return contestRepo.getContestProblemListByContestId(contestid);
    }
}
