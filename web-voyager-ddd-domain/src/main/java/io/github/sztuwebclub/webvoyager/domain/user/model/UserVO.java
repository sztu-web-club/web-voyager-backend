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
public class UserVO {
    private Long id;
    private String username;
    private Integer entryyear;
    private String userid;
    private String nickname;
    private Date createtime;
    private String ssoid;
    private String major;
    private Object role;
}
