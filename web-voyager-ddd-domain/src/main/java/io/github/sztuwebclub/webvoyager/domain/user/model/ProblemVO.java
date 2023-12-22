package io.github.sztuwebclub.webvoyager.domain.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProblemVO {
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
