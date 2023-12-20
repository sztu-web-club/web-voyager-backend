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
    private String userId;
    private String userNickname;
    private Date createTime;
}
