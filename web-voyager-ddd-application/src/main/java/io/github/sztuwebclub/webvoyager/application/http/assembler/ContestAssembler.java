package io.github.sztuwebclub.webvoyager.application.http.assembler;


import io.github.sztuwebclub.webvoyager.api.user.request.ContestCreatRequest;
import io.github.sztuwebclub.webvoyager.domain.Contest.Contest;

public class ContestAssembler {
    public static Contest contestCreatRequestToContest(ContestCreatRequest contestCreatRequest){
        return Contest.builder()
                .name(contestCreatRequest.getName())
                .desp(contestCreatRequest.getDesp())
                .starttime(contestCreatRequest.getStarttime())
                .endtime(contestCreatRequest.getEndtime())
                .build();
    }
}
