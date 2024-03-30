package io.github.sztuwebclub.webvoyager.infra.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@TableName(value ="solution")
public class SolutionPO {
    private Long id;
    private Integer problemId;
    private Integer userId;
    private Integer contestId;
    private Integer time;
    private Integer memory;
    private Integer result;
    private String language;
    private String code;
    private Integer passedTest;
    private Integer totalTest;
    private Integer judgerId;
}
