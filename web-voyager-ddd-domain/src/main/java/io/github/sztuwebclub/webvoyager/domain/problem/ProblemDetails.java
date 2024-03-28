package io.github.sztuwebclub.webvoyager.domain.problem;

import io.github.sztuwebclub.webvoyager.constant.AuditableEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
public class ProblemDetails extends AuditableEntity {
    private Integer id;
    private String description;
    private String hintInput;
    private String hintOutput;
    private String sampleInput;
    private String sampleOutput;
    private String hint;
    private String input;
    private String output;
}
