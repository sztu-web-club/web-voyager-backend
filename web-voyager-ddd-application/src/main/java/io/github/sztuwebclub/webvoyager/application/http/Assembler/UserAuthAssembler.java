package io.github.sztuwebclub.webvoyager.application.http.assembler;

import io.github.sztuwebclub.webvoyager.api.model.DTO.UserLoginRequestDTO;
import io.github.sztuwebclub.webvoyager.api.model.response.UserLoginResp;
import io.github.sztuwebclub.webvoyager.domain.user.UserAuth;

import org.springframework.stereotype.Component;

@Component
public class UserAuthAssembler {
    public static UserAuth UserLoginRequestDTOToUserAuthVO(UserLoginRequestDTO userLoginRequestDTO){
        return UserAuth.builder()
                .username(userLoginRequestDTO.getUsername())
                .password(userLoginRequestDTO.getPassword())
                .uuid(userLoginRequestDTO.getUuid())
                .timestamp(userLoginRequestDTO.getTimestamp())
                .build();
    }

    public static UserLoginResp UserLoginVOToUserLoginResp(UserAuth userAuthVO){
        return UserLoginResp.builder()
                .id(userAuthVO.getId())
                .token(userAuthVO.getToken())
                .build();
    }
}
