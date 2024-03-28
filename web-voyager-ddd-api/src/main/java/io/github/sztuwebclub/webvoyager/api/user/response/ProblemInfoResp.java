package io.github.sztuwebclub.webvoyager.api.user.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProblemInfoResp implements Serializable {
    private Long id;
    private String title;
    private Double timeLimit;
    private Integer memoryLimit;
    private Integer totalSolved;
    private Integer totalSubmit;
    private Integer authorId;
    private String authorName;
    private String description;
    private String hintInput;
    private String hintOutput;
    private String sampleInput;
    private String sampleOutput;
    private String hint;
    private String input;
    private String output;
}
