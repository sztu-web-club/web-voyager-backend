package io.github.sztuwebclub.webvoyager.application.http.assembler;

import io.github.sztuwebclub.webvoyager.api.user.response.ProblemInfoResp;
import io.github.sztuwebclub.webvoyager.domain.problem.Problem;
import io.github.sztuwebclub.webvoyager.domain.problem.ProblemDetails;

public class ProblemAssembler {
    public static ProblemInfoResp problemWithDetailsToProblemInfoResp(Problem problem, ProblemDetails problemDetails){
        return ProblemInfoResp.builder()
                .id(problem.getId())
                .title(problem.getTitle())
                .timeLimit(problem.getTimeLimit())
                .memoryLimit(problem.getMemoryLimit())
                .totalSolved(problem.getTotalSolved())
                .totalSubmit(problem.getTotalSubmit())
                .authorId(problem.getAuthorId())
                .authorName(problem.getAuthorName())
                .description(problemDetails.getDescription())
                .hintInput(problemDetails.getInput())
                .hintOutput(problemDetails.getOutput())
                .sampleInput(problemDetails.getSampleInput())
                .sampleOutput(problemDetails.getSampleOutput())
                .hint(problemDetails.getHint())
                .input(problemDetails.getInput())
                .output(problemDetails.getOutput())
                .build();
    }
}
