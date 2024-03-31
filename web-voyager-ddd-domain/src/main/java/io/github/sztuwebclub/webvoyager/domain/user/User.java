package io.github.sztuwebclub.webvoyager.domain.user;

import io.github.sztuwebclub.webvoyager.constant.AuditableEntity;
import io.github.sztuwebclub.webvoyager.constant.model.PageResult;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
public class User extends AuditableEntity implements Serializable {
    private Long id;
    private String username;
    private Integer entryyear;
    private String userid;
    private String nickname;
    private Date createtime;
    private String ssoid;
    private String major;
    private UserRoleEnum role;

    public PageResult<User> pageQuery(Integer page, Integer pagesize, IUserRepo userRepo) {
        Integer total = userRepo.userCount(username);
        Integer start = (page - 1)*pagesize;
        List<User> resultList = userRepo.pageQuery(start, pagesize, username);
        return new PageResult<>(total, start + 1, pagesize, resultList);
    }

    public User getUserById(IUserRepo userRepo) {
        return userRepo.getUserById(id);
    }

}
