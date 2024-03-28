package io.github.sztuwebclub.webvoyager.application.http.controller;

import io.github.sztuwebclub.webvoyager.api.user.request.UserLoginRequest;
import io.github.sztuwebclub.webvoyager.api.user.response.UserListResp;
import io.github.sztuwebclub.webvoyager.api.user.response.UserLoginResp;
import io.github.sztuwebclub.webvoyager.application.http.assembler.UserAssembler;
import io.github.sztuwebclub.webvoyager.constant.ResponseCode;
import io.github.sztuwebclub.webvoyager.constant.model.Response;
import io.github.sztuwebclub.webvoyager.domain.Service.UserService;
import io.github.sztuwebclub.webvoyager.domain.user.User;
import io.github.sztuwebclub.webvoyager.domain.user.UserAuth;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/success")
    public Response<String> success() {
        log.info("测试调用");
        return Response.<String>builder()
                .code(ResponseCode.SUCCESS.getCode())
                .info(ResponseCode.SUCCESS.getInfo())
                .data("查询用户信息")
                .build();
    }

    @GetMapping("/user/list")
    public Response<UserListResp> list(){
        log.info("用户列表获取");
        List<User> userList = userService.list();
        UserListResp userListResp = new UserListResp(userList);
        return Response.<UserListResp>builder()
                .code(ResponseCode.SUCCESS.getCode())
                .info(ResponseCode.SUCCESS.getInfo())
                .data(userListResp)
                .build();
    }

    @PostMapping("/user/login")
    public Response<UserLoginResp> login(@RequestBody UserLoginRequest userLoginRequest){
        log.info("用户登录：{}", userLoginRequest);
        UserAuth userAuth = UserAssembler.userLoginRequestToUserAuth(userLoginRequest);
        String token = userService.login(userAuth);
        UserLoginResp userLoginResp = UserAssembler.userAuthToUserLoginResp(userAuth);
        userLoginResp.setToken(token);
        return Response.<UserLoginResp>builder()
                .code(ResponseCode.SUCCESS.getCode())
                .info(ResponseCode.SUCCESS.getInfo())
                .data(userLoginResp)
                .build();
    }
}
