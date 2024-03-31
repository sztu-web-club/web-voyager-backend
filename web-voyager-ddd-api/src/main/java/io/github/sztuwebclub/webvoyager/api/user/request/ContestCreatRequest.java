package io.github.sztuwebclub.webvoyager.api.user.request;

import io.github.sztuwebclub.webvoyager.domain.contest.ContestProblem;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Data
public class ContestCreatRequest {
    private String name;
    private String desp;
    private Date starttime;
    private Date endtime;
    private List<ConcurrentHashMap<String, Object>> contestProblemMap;
}
