package io.github.sztuwebclub.webvoyager.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum JwtProperties {
    USER(7200000,"token"),
    ADMIN(7200000,"token");

    private long ttl;
    private String tokenName;
}
