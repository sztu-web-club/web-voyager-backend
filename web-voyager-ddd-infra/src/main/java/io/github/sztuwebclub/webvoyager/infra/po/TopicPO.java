package io.github.sztuwebclub.webvoyager.infra.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@TableName(value ="topic")
public class TopicPO {
    private Long topicId;
    private Integer userId;
    private String content;
    private Integer reply;
    private Integer publicShow;
    private Integer contestId;
    private Date inDate;
    private Integer problemId;
}
