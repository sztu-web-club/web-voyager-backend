package io.github.sztuwebclub.webvoyager.api.user.response;

import io.github.sztuwebclub.webvoyager.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserListResp implements Serializable {
    private List<User> userList;
}
