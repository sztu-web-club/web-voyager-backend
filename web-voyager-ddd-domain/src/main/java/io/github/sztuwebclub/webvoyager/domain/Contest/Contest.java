package io.github.sztuwebclub.webvoyager.domain.Contest;

import io.github.sztuwebclub.webvoyager.constant.AuditableEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
public class Contest extends AuditableEntity {
    private Long id;
    private String name;
    private Date starttime;
    private Date endtime;
    private String desp;
    private boolean isprivate;
}
