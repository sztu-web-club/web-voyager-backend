package io.github.sztuwebclub.webvoyager.application.http.assembler;

import io.github.sztuwebclub.webvoyager.api.user.request.UserLoginRequest;
import io.github.sztuwebclub.webvoyager.api.user.response.UserLoginResp;
import io.github.sztuwebclub.webvoyager.domain.user.UserAuth;

import org.springframework.stereotype.Component;

@Component
public class UserAuthAssembler {
    private UserAuthAssembler() {}
    public static UserAuth userLoginRequestDTOToUserAuthVO(UserLoginRequest userLoginRequest){
        return UserAuth.builder()
                .username(userLoginRequest.getUsername())
                .password(userLoginRequest.getPassword())
                .uuid(userLoginRequest.getUuid())
                .timestamp(userLoginRequest.getTimestamp())
                .build();
    }

    public static UserLoginResp userLoginVOToUserLoginResp(UserAuth userAuthVO){
        return UserLoginResp.builder()
                .id(userAuthVO.getId())
                .token(userAuthVO.getToken())
                .build();
    }
}
