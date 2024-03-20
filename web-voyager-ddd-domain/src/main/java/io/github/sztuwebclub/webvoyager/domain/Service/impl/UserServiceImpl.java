package io.github.sztuwebclub.webvoyager.domain.Service.impl;

import io.github.sztuwebclub.webvoyager.domain.Service.UserService;
import io.github.sztuwebclub.webvoyager.domain.user.IUserRepo;
import io.github.sztuwebclub.webvoyager.domain.user.UserAuth;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private IUserRepo userRepo;

    @Override
    public String login(UserAuth userAuthVO) {
        return userAuthVO.login(userRepo);
    }

}
