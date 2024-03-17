package io.github.sztuwebclub.webvoyager.application.http.controller;

import io.github.sztuwebclub.webvoyager.api.user.request.UserLoginRequest;
import io.github.sztuwebclub.webvoyager.api.user.response.UserLoginResp;
import io.github.sztuwebclub.webvoyager.application.http.assembler.UserAuthAssembler;
import io.github.sztuwebclub.webvoyager.constant.ResponseCode;
import io.github.sztuwebclub.webvoyager.constant.model.Response;
import io.github.sztuwebclub.webvoyager.domain.user.UserAuth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController {

    @RequestMapping("/success")
    public Response<String> success() {
        log.info("测试调用");
        return Response.<String>builder()
                .code(ResponseCode.SUCCESS.getCode())
                .info(ResponseCode.SUCCESS.getInfo())
                .data("查询用户信息")
                .build();
    }

    @RequestMapping("/user/login")
    public Response<UserLoginResp> login(@RequestBody UserLoginRequest userLoginRequest){
        log.info("员工登录：{}", userLoginRequest);
        UserAuth userAuthVO = UserAuthAssembler.userLoginRequestDTOToUserAuthVO(userLoginRequest);
        userAuthVO.login();
        UserLoginResp userLoginResp = UserAuthAssembler.userLoginVOToUserLoginResp(userAuthVO);
        return Response.<UserLoginResp>builder()
                .code(ResponseCode.SUCCESS.getCode())
                .info(ResponseCode.SUCCESS.getInfo())
                .data(userLoginResp)
                .build();
    }
}
