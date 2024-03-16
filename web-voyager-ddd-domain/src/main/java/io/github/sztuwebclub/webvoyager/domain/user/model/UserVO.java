package io.github.sztuwebclub.webvoyager.domain.user.model;


import io.github.sztuwebclub.webvoyager.domain.user.repo.IUserRepo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.DigestUtils;
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
