package io.github.sztuwebclub.webvoyager.application.http.controller;

import io.github.sztuwebclub.webvoyager.api.user.request.UserLoginRequest;
import io.github.sztuwebclub.webvoyager.api.user.response.UserLoginResp;
import io.github.sztuwebclub.webvoyager.application.http.assembler.UserAssembler;
import io.github.sztuwebclub.webvoyager.constant.ResponseCode;
import io.github.sztuwebclub.webvoyager.constant.model.PageResult;
import io.github.sztuwebclub.webvoyager.constant.model.Response;
import io.github.sztuwebclub.webvoyager.constant.utils.ContextUtil;
import io.github.sztuwebclub.webvoyager.domain.service.IUserService;
import io.github.sztuwebclub.webvoyager.domain.user.User;
import io.github.sztuwebclub.webvoyager.domain.user.UserAuth;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class UserController {
    @Resource
    private IUserService userService;

    @GetMapping("/user/page")
    public Response<PageResult<User>> page(@RequestParam("page")Integer page,
                                           @RequestParam("pagesize")Integer pagesize,
                                           @RequestParam("username")String username){
        log.info("用户列表获取");
        PageResult<User> pageResult = userService.pageQuery(page,pagesize,username);
        return Response.<PageResult<User>>builder()
                .code(ResponseCode.SUCCESS.getCode())
                .info(ResponseCode.SUCCESS.getInfo())
                .data(pageResult)
                .build();
    }

    @GetMapping("/user/info/{id}")
    public Response<User> info(@PathVariable("id") Integer id){
        log.info("用户详细信息获取");
        User user = userService.getUserById(id);
        return Response.<User>builder()
                .code(ResponseCode.SUCCESS.getCode())
                .info(ResponseCode.SUCCESS.getInfo())
                .data(user)
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

    @GetMapping("/user/logout")
    public Response<String> logout(HttpServletRequest request){
        log.info("用户登出:{}", ContextUtil.getCurrentId());
        String token = request.getHeader("Authorization");
        userService.logout(ContextUtil.getCurrentId(),token);
        return Response.<String>builder()
                .code(ResponseCode.SUCCESS.getCode())
                .info(ResponseCode.SUCCESS.getInfo())
                .data("用户登出")
                .build();
    }
}
