package io.github.sztuwebclub.webvoyager.api.user.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContestInfoResp implements Serializable {
    private Long id;
    private String name;
    private Date startTime;
    private Date endTime;
    private String desp;
    private Boolean isprivate;
    private transient List<ConcurrentHashMap<String, Object>> contestProblemList;
}
