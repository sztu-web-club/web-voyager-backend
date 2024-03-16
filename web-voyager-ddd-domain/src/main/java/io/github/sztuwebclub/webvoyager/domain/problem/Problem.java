package io.github.sztuwebclub.webvoyager.domain.problem;

import io.github.sztuwebclub.webvoyager.constant.AuditableEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
public class Problem extends AuditableEntity {
    private Long id;
    private String title;
    private String description;
    private String hint;
    private Double timeLimit;
    private Integer memoryLimit;
    private Integer totalSolved;
    private Integer totalSubmit;
    private Integer authorId;
}
