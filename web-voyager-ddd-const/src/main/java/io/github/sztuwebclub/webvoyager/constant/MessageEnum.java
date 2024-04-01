package io.github.sztuwebclub.webvoyager.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum MessageEnum {

    // 合并错误消息防止穷举用户名
    ACCOUNT_NOT_FOUND_OR_PASSWORD_ERROR("账号不存在或密码错误"),
    ACCOUNT_LOCKED("账号被锁定"),
    UNKNOWN_ERROR("未知错误"),
    ALREADY_EXISTS("已存在"),
    WRONG_PARAMETER("参数错误");

    private String message;

}
