package io.github.sztuwebclub.webvoyager.domain.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAuthVO {
    private Long id;
    private String username;
    private String password;
    private String uuid;
    private String timestamp;
    private String token;

    public void login() {
        token = "123456";
    }
}