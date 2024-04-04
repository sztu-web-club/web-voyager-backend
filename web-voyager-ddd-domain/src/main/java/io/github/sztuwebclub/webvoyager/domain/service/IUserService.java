package io.github.sztuwebclub.webvoyager.domain.service;

import io.github.sztuwebclub.webvoyager.constant.model.PageResult;
import io.github.sztuwebclub.webvoyager.domain.user.User;
import io.github.sztuwebclub.webvoyager.domain.user.UserAuth;

public interface IUserService {
    String login(UserAuth userAuthVO);

    PageResult<User> pageQuery(Integer page, Integer pagesize, String title);

    User getUserById(Integer id);

    void logout(Integer userId, String token);
}
