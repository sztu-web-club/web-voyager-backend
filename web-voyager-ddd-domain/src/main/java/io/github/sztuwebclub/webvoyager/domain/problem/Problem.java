package io.github.sztuwebclub.webvoyager.domain.problem;

import io.github.sztuwebclub.webvoyager.constant.AuditableEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
public class Problem extends AuditableEntity implements Serializable {
    private Long id;
    private String title;
    private Double timeLimit;
    private Integer memoryLimit;
    private Integer totalSolved;
    private Integer totalSubmit;
    private Integer authorId;
    private String authorName;

}
