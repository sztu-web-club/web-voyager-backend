package io.github.sztuwebclub.webvoyager.domain.user.service.impl;

import io.github.sztuwebclub.webvoyager.domain.user.model.UserVO;
import io.github.sztuwebclub.webvoyager.domain.user.repo.IUserRepo;
import io.github.sztuwebclub.webvoyager.domain.user.service.IUserService;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserRepo userRepo;

    @Override
    public List<UserVO> queryUserList() {
        return userRepo.queryUserList();
    }

}
