package io.github.sztuwebclub.webvoyager.infra.repo;

import io.github.sztuwebclub.webvoyager.domain.user.repo.IUserRepo;
import io.github.sztuwebclub.webvoyager.infra.dao.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepo implements IUserRepo {

    @Resource
    private UserMapper userDao;

}