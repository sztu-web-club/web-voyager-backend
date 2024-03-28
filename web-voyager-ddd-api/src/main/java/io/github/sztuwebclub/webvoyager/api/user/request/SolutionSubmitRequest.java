package io.github.sztuwebclub.webvoyager.api.user.request;

import lombok.Data;

@Data
public class SolutionSubmitRequest {
    private String code;
    private String lang;
    private Integer constestid;
}
