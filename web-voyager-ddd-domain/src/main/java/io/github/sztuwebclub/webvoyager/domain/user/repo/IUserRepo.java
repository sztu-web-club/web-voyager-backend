package io.github.sztuwebclub.webvoyager.domain.user.repo;

import io.github.sztuwebclub.webvoyager.domain.user.model.UserVO;

import java.util.List;

public interface IUserRepo {
    List<UserVO> queryUserList();
}
