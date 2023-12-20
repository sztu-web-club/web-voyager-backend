package io.github.sztuwebclub.webvoyager.infra.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.sztuwebclub.webvoyager.infra.po.UserPO;

import java.util.List;

public interface UserMapper extends BaseMapper<UserPO> {
    List<UserPO> queryUserList();
}
