package io.github.sztuwebclub.webvoyager.api.user.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TopicPage implements Serializable {
    private Long topicid;
    private String nickname;
    private String content;
    private Integer reply;
    private Integer publicshow;
    private Integer contestid;
    private Date indate;
    private Integer problemid;
}
