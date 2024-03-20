package io.github.sztuwebclub.webvoyager.constant.enumerate;

public enum MessageEnum {

    PASSWORD_ERROR("密码错误"),
    ACCOUNT_NOT_FOUND("账号不存在"),
    ACCOUNT_LOCKED("账号被锁定"),
    UNKNOWN_ERROR("未知错误"),
    ALREADY_EXISTS("已存在");

    private final String message;

    MessageEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
