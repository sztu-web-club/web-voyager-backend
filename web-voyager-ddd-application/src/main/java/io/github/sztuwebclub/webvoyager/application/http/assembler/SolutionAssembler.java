package io.github.sztuwebclub.webvoyager.application.http.assembler;

import io.github.sztuwebclub.webvoyager.api.user.request.SolutionSubmitRequest;
import io.github.sztuwebclub.webvoyager.domain.solution.Solution;

public class SolutionAssembler {
    public static Solution solutionSubmitRequestToSolution(SolutionSubmitRequest solutionSubmitRequest){
        return Solution.builder()
                .code(solutionSubmitRequest.getCode())
                .language(solutionSubmitRequest.getLang())
                .contestid(solutionSubmitRequest.getConstestid())
                .build();
    }
}
