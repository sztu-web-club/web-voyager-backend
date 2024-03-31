package io.github.sztuwebclub.webvoyager.domain.service.impl;

import io.github.sztuwebclub.webvoyager.constant.model.PageResult;
import io.github.sztuwebclub.webvoyager.domain.service.IUserService;
import io.github.sztuwebclub.webvoyager.domain.user.IUserRepo;
import io.github.sztuwebclub.webvoyager.domain.user.User;
import io.github.sztuwebclub.webvoyager.domain.user.UserAuth;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Resource
    private IUserRepo userRepo;

    @Override
    public String login(UserAuth userAuth) {
        return userAuth.login(userRepo);
    }

    @Override
    public PageResult<User> pageQuery(Integer page, Integer pagesize, String username) {
        User user = User.builder()
                .username(username)
                .build();
        return user.pageQuery(page,pagesize,userRepo);
    }

    @Override
    public User getUserById(Integer id) {
        User user = User.builder()
                .id(Long.valueOf(id))
                .build();
        return user.getUserById(userRepo);
    }

}
