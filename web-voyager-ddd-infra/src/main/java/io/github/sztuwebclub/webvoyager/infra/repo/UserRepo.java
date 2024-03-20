package io.github.sztuwebclub.webvoyager.infra.repo;

import io.github.sztuwebclub.webvoyager.domain.user.IUserRepo;
import io.github.sztuwebclub.webvoyager.domain.user.UserAuth;
import io.github.sztuwebclub.webvoyager.infra.dao.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepo implements IUserRepo {

    @Resource
    private UserMapper userDao;
    @Override
    public UserAuth getUserAuthByUsername(String username) {
        return userDao.getUserAuthByUsername(username);
    }

}