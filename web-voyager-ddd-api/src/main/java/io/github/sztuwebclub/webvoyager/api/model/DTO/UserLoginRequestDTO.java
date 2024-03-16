package io.github.sztuwebclub.webvoyager.api.model.DTO;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserLoginRequestDTO implements Serializable {
    private String username;
    private String password;
    private String uuid;
    private String timestamp;
}
