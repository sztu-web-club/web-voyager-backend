package io.github.sztuwebclub.webvoyager.api.user.request;

import lombok.Data;

import java.util.Date;

@Data
public class ContestCreatRequest {
    private String name;
    private String desp;
    private Date starttime;
    private Date endtime;
}
