package io.github.sztuwebclub.webvoyager.application.http.assembler;

import io.github.sztuwebclub.webvoyager.api.user.request.UserLoginRequest;
import io.github.sztuwebclub.webvoyager.api.user.response.UserLoginResp;
import io.github.sztuwebclub.webvoyager.domain.user.UserAuth;

public class UserAssembler {

    public static UserAuth userLoginRequestToUserAuth(UserLoginRequest userLoginRequest){
        return UserAuth.builder()
                .id((long)1)
                .username(userLoginRequest.getUsername())
                .password(userLoginRequest.getPassword())
                .build();
    }

    public static UserLoginResp userAuthToUserLoginResp(UserAuth userAuthVO){
        return UserLoginResp.builder()
                .id(userAuthVO.getId())
                .token("")
                .build();
    }

}
