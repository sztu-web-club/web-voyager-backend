package io.github.sztuwebclub.webvoyager.infra.enumerate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum UserRoleEnum {
    SUCCESS(0, "游客"),
    UN_ERROR(1, "普通用户"),
    ILLEGAL_PARAMETER(2, "普通管理员"),
    UNAUTHORIZED(3, "系统管理员");

    private int power;
    private String name;
}
