package io.github.sztuwebclub.webvoyager.domain.user.service.impl;

import io.github.sztuwebclub.webvoyager.domain.user.repo.IUserRepo;
import io.github.sztuwebclub.webvoyager.domain.user.service.IUserService;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserRepo userRepo;

}
