package io.github.sztuwebclub.webvoyager.domain.user.service;

import io.github.sztuwebclub.webvoyager.domain.user.model.UserVO;

import java.util.List;

public interface IUserService {

    List<UserVO> queryUserList();

}
