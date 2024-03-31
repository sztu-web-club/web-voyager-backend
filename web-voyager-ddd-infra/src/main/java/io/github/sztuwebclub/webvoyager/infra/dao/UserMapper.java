package io.github.sztuwebclub.webvoyager.infra.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.sztuwebclub.webvoyager.domain.user.User;
import io.github.sztuwebclub.webvoyager.domain.user.UserAuth;
import io.github.sztuwebclub.webvoyager.infra.po.UserPO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper extends BaseMapper<UserPO> {

    Integer userCount(@Param("username") String username);

    List<User> pageQuery(@Param("start") Integer start, @Param("pagesize") Integer pagesize, @Param("username") String username);

    @Select("select id,username,entry_year,email,nickname,create_time,sso_id,major,role from user where id = #{id}")
    User getUserById(@Param("id") Long id);

    @Select("select id,username,password from user where username = #{username}")
    UserAuth getUserAuthByUsername(@Param("username") String username);
}
