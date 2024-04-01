package io.github.sztuwebclub.webvoyager.domain.topic;

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
public class Topic extends AuditableEntity implements Serializable {
    private Long topicid;
    private Integer userid;
    private String content;
    private Integer reply;
    private Integer publicshow;
    private Integer contestid;
    private Date indate;
    private Integer problemid;

    public PageResult<Topic> pageQuery(Integer page, Integer pagesize, ITopicUserRepo topicRepo) {
        Integer total = topicRepo.topicCount(problemid,contestid,reply);
        Integer start = (page - 1)*pagesize;
        List<Topic> resultList = topicRepo.pageQuery(start, pagesize, problemid,contestid,reply);
        return new PageResult<>(total, start + 1, pagesize, resultList);
    }
}
