package io.github.sztuwebclub.webvoyager.infra.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@TableName(value ="contest_problem")
public class ContestProblemPO {
    private Integer contestId;
    private Integer problemId;
    private Integer sequence;
    private String title;
}
