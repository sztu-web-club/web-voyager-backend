package io.github.sztuwebclub.webvoyager.application.http.Assembler;

import io.github.sztuwebclub.webvoyager.api.model.DTO.UserLoginRequestDTO;
import io.github.sztuwebclub.webvoyager.api.model.response.UserLoginResp;
import io.github.sztuwebclub.webvoyager.domain.user.model.UserAuthVO;
import org.springframework.stereotype.Component;

@Component
public class UserAuthAssembler {
    public static UserAuthVO UserLoginRequestDTOToUserAuthVO(UserLoginRequestDTO userLoginRequestDTO){
        UserAuthVO userAuthVO = new UserAuthVO();
        return userAuthVO.builder()
                .username(userLoginRequestDTO.getUsername())
                .password(userLoginRequestDTO.getPassword())
                .uuid(userLoginRequestDTO.getUuid())
                .timestamp(userLoginRequestDTO.getTimestamp())
                .build();
    }

    public static UserLoginResp UserLoginVOToUserLoginResp(UserAuthVO userAuthVO){
        UserLoginResp userLoginResp = new UserLoginResp();
        return userLoginResp.builder()
                .id(userAuthVO.getId())
                .token(userAuthVO.getToken())
                .build();
    }
}
