package io.github.sztuwebclub.webvoyager.domain.contest;

import io.github.sztuwebclub.webvoyager.constant.AuditableEntity;
import io.github.sztuwebclub.webvoyager.constant.model.PageResult;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
public class Contest extends AuditableEntity implements Serializable {
    private Long id;
    private String name;
    private Date starttime;
    private Date endtime;
    private String desp;
    private boolean isprivate;

    public void creatContest(IContestRepo contestRepo) {
        contestRepo.creatContest(name,starttime,endtime,desp);
    }
    public PageResult<Contest> pageQuery(Integer page, Integer pagesize, IContestRepo contestRepo) {
        Integer total = contestRepo.contestCount(name);
        int start = (page - 1)*pagesize;
        List<Contest> resultList = contestRepo.pageQuery(start, pagesize, name);
        return new PageResult<>(total, start + 1, pagesize, resultList);
    }

    public Contest getContestById(IContestRepo contestRepo) {
        return contestRepo.getContestById(id);
    }

    public Contest getContestByName(IContestRepo contestRepo) {return contestRepo.getContestByName(name); }
}
