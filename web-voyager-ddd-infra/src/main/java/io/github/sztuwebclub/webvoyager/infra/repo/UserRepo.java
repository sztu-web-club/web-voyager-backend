package io.github.sztuwebclub.webvoyager.infra.repo;

import io.github.sztuwebclub.webvoyager.domain.user.IUserRepo;
import io.github.sztuwebclub.webvoyager.domain.user.User;
import io.github.sztuwebclub.webvoyager.domain.user.UserAuth;
import io.github.sztuwebclub.webvoyager.infra.dao.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepo implements IUserRepo {

    @Resource
    private UserMapper userDao;

    @Override
    public Integer userCount(String username) {
        return userDao.userCount(username);
    }

    @Override
    public List<User> pageQuery(Integer start, Integer pagesize, String username) {
        return userDao.pageQuery(start,pagesize,username);
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public UserAuth getUserAuthByUsername(String username) {
        return userDao.getUserAuthByUsername(username);
    }

}