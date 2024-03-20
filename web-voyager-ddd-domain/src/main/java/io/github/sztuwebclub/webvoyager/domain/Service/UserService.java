package io.github.sztuwebclub.webvoyager.domain.Service;

import io.github.sztuwebclub.webvoyager.domain.user.UserAuth;

public interface UserService {
    String login(UserAuth userAuthVO);
}
