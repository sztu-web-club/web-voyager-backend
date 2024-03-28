package io.github.sztuwebclub.webvoyager.domain.user;

import io.github.sztuwebclub.webvoyager.constant.AuditableEntity;
import io.github.sztuwebclub.webvoyager.constant.JwtProperties;
import io.github.sztuwebclub.webvoyager.constant.enumerate.JwtClaimsEnum;
import io.github.sztuwebclub.webvoyager.constant.MessageEnum;
import io.github.sztuwebclub.webvoyager.constant.model.BaseException;
import io.github.sztuwebclub.webvoyager.constant.utils.JwtUtil;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
public class UserAuth extends AuditableEntity {
    private Long id;
    private String username;
    private String password;

    public String login(IUserRepo userRepo) {
        UserAuth userAuth = userRepo.getUserAuthByUsername(username);

        if (userAuth == null) {
            throw new BaseException(MessageEnum.ACCOUNT_NOT_FOUND.toString());
        }

        // TODO md5改sha1
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!password.equals(userAuth.getPassword())) {
            //密码错误
            throw new BaseException(MessageEnum.PASSWORD_ERROR.toString());
        }

//        暂未设计账户冻结状态
//        if (userAuth.getStatus() == StatusConstant.DISABLE) {
//            throw new BaseException(MessageEnum.ACCOUNT_LOCKED.toString());
//        }

        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsEnum.USER_ID.toString(), userAuth.getId());
        String token = JwtUtil.createJWT(JwtProperties.USER.getTtl(), claims);

        return token;
    }
}