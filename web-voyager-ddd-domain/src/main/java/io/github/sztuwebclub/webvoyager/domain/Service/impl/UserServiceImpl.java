package io.github.sztuwebclub.webvoyager.domain.Service.impl;

import io.github.sztuwebclub.webvoyager.domain.Service.UserService;
import io.github.sztuwebclub.webvoyager.domain.user.IUserRepo;
import io.github.sztuwebclub.webvoyager.domain.user.User;
import io.github.sztuwebclub.webvoyager.domain.user.UserAuth;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private IUserRepo userRepo;

    @Override
    public String login(UserAuth userAuth) {
        return userAuth.login(userRepo);
    }

    @Override
    public List<User> list() {
        return User.list(userRepo);
    }

}
