package io.github.sztuwebclub.webvoyager.domain.solution;

import io.github.sztuwebclub.webvoyager.constant.AuditableEntity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
public class Solution extends AuditableEntity {
    private Long id;
    private Integer problemid;
    private Integer userid;
    private Integer contestid;
    private Integer time;
    private Integer memory;
    private Integer result;
    private String language;
    private String code;
    private Integer passedtest;
    private Integer totaltest;
    private Integer judgerid;

    public void submit() {
        //TODO 调用沙箱判题和保存
    }
}
