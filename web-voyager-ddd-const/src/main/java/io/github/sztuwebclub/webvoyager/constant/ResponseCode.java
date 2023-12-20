package io.github.sztuwebclub.webvoyager.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 返回代码
 * @author elysiaEgo
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ResponseCode {
    SUCCESS(0, "成功"),
    UN_ERROR(1, "未知失败"),
    ILLEGAL_PARAMETER(2, "非法参数"),
    UNAUTHORIZED(3, "未授权"),
    EXPIRED_TOKEN(4, "token已过期");

    private Integer code;
    private String info;

}
