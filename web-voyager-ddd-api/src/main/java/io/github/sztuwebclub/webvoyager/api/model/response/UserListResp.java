package io.github.sztuwebclub.webvoyager.api.model.response;

import io.github.sztuwebclub.webvoyager.domain.user.model.UserVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserListResp {
    private List<UserVO> userList;
}
