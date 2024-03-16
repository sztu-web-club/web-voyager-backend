package io.github.sztuwebclub.webvoyager.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum JwtProperties {
    USER("123456",7200000,"token"),
    ADMIN("123456",7200000,"token");

    private String SecretKey;
    private long Ttl;
    private String TokenName;
}
