package io.github.sztuwebclub.webvoyager.infra.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.sztuwebclub.webvoyager.domain.user.User;
import io.github.sztuwebclub.webvoyager.domain.user.UserAuth;
import io.github.sztuwebclub.webvoyager.infra.po.UserPO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper extends BaseMapper<UserPO> {
    @Select("select id,username,password from user where username = #{username}")
    UserAuth getUserAuthByUsername(String username);

    @Select("select id,username,entry_year,userid,nickname,create_time,sso_id,major,role from user")
    List<User> getUserList();
}
