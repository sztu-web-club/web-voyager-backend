package io.github.sztuwebclub.webvoyager.infra.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPO {
    // user info
    private Long id;
    private String userId;
    private String username;
    private String password;
    private String nickname;
    private Date createTime;
    // SZTU student
    private String ssoId;
    private String realname;
    private Integer entryYear;
    private String major;
}
