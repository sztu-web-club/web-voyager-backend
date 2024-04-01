package io.github.sztuwebclub.webvoyager.domain.user;

import io.github.sztuwebclub.webvoyager.constant.AuditableEntity;
import io.github.sztuwebclub.webvoyager.constant.JwtProperties;
import io.github.sztuwebclub.webvoyager.constant.enumerate.JwtClaimsEnum;
import io.github.sztuwebclub.webvoyager.constant.MessageEnum;
import io.github.sztuwebclub.webvoyager.constant.model.BaseException;
import io.github.sztuwebclub.webvoyager.constant.utils.JwtUtil;
import io.github.sztuwebclub.webvoyager.constant.utils.PasswordUtil;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
public class UserAuth extends AuditableEntity {
    private Long id;
    private String username;
    // 前端传入SHA1，使用BCryptPasswordEncoder加密
    private String password;

    public String login(IUserRepo userRepo) {
        UserAuth userAuth = userRepo.getUserAuthByUsername(username);

        if (userAuth == null) {
            throw new BaseException(MessageEnum.ACCOUNT_NOT_FOUND_OR_PASSWORD_ERROR.toString());
        }

        var epassword = PasswordUtil.encrypt(password);

        if (!epassword.equals(userAuth.getPassword())) {
            throw new BaseException(MessageEnum.ACCOUNT_NOT_FOUND_OR_PASSWORD_ERROR.toString());
        }

//        暂未设计账户冻结状态
//        if (userAuth.getStatus() == StatusConstant.DISABLE) {
//            throw new BaseException(MessageEnum.ACCOUNT_LOCKED.toString());
//        }

        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsEnum.USER_ID.toString(), userAuth.getId());
        return JwtUtil.createJWT(JwtProperties.USER.getTtl(), claims);
    }
}