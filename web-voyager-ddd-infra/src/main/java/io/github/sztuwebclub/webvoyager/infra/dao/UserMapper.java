package io.github.sztuwebclub.webvoyager.infra.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.sztuwebclub.webvoyager.domain.user.UserAuth;
import io.github.sztuwebclub.webvoyager.infra.po.UserPO;
import org.apache.ibatis.annotations.Select;

public interface UserMapper extends BaseMapper<UserPO> {
    @Select("select id,username,password from user where username = #{username}")
    UserAuth getUserAuthByUsername(String username);
}
