package io.github.sztuwebclub.webvoyager.domain.user;

import io.github.sztuwebclub.webvoyager.constant.AuditableEntity;
import lombok.*;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
public class User extends AuditableEntity {
    private Long id;
    private String username;
    private Integer entryyear;
    private String userid;
    private String nickname;
    private Date createtime;
    private String ssoid;
    private String major;
    private UserRoleEnum role;
}
