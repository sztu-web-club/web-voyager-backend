package io.github.sztuwebclub.webvoyager.domain.Service;

import io.github.sztuwebclub.webvoyager.domain.user.User;
import io.github.sztuwebclub.webvoyager.domain.user.UserAuth;

import java.util.List;

public interface UserService {
    String login(UserAuth userAuthVO);


    List<User> list();
}
