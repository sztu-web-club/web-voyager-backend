package io.github.sztuwebclub.webvoyager.domain.topic;

import io.github.sztuwebclub.webvoyager.constant.AuditableEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

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
}
