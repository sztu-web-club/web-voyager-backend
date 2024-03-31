package io.github.sztuwebclub.webvoyager.application.http.assembler;

import io.github.sztuwebclub.webvoyager.api.user.request.ContestCreatRequest;
import io.github.sztuwebclub.webvoyager.api.user.response.ContestInfoResp;
import io.github.sztuwebclub.webvoyager.domain.contest.Contest;
import io.github.sztuwebclub.webvoyager.domain.contest.ContestProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ContestAssembler {

    public static ContestInfoResp contestWithProblemListToContestInfoResp(Contest contest, List<ContestProblem> contestProblemList) {
        List<ConcurrentHashMap<String, Object>> problemIdAndTitleList = new ArrayList<>();

        for (ContestProblem contestProblem : contestProblemList) {
            ConcurrentHashMap<String, Object> problemInfo = new ConcurrentHashMap<>();
            problemInfo.put("problemId", contestProblem.getProblemid());
            problemInfo.put("title", contestProblem.getTitle());
            problemInfo.put("sequence",contestProblem.getSequence());
            problemIdAndTitleList.add(problemInfo);
        }

        return ContestInfoResp.builder()
                .id(contest.getId())
                .name(contest.getName())
                .startTime(contest.getStarttime())
                .endTime(contest.getEndtime())
                .desp(contest.getDesp())
                .isprivate(contest.isIsprivate())
                .contestProblemList(problemIdAndTitleList)
                .build();
    }

    public static List<ContestProblem> contestCreatRequestToContestProblemList(ContestCreatRequest contestCreatRequest){
        List<ContestProblem> contestProblemList = new ArrayList<>();
        for (ConcurrentHashMap<String, Object> map : contestCreatRequest.getContestProblemMap()) {
            ContestProblem contestProblem = ContestProblem.builder()
                    .problemid((Integer) map.get("problemId"))
                    .sequence((Integer) map.get("sequence"))
                    .title((String) map.get("title"))
                    .build();
            contestProblemList.add(contestProblem);
        }
        return contestProblemList;
    }

}
