package io.github.sztuwebclub.webvoyager.infra.repo;

import io.github.sztuwebclub.webvoyager.domain.user.model.UserVO;
import io.github.sztuwebclub.webvoyager.domain.user.repo.IUserRepo;
import io.github.sztuwebclub.webvoyager.infra.dao.UserMapper;
import io.github.sztuwebclub.webvoyager.infra.po.UserPO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepo implements IUserRepo {

    @Resource
    private UserMapper userDao;

    @Override
    public List<UserVO> queryUserList() {
        List<UserVO> userInfoList = new ArrayList<>();
        List<UserPO> users = userDao.queryUserList();
        for (UserPO user : users) {
            UserVO userInfo = UserVO.builder()
                    .userId(user.getUserId())
                    .userNickname(user.getNickname())
                    .createTime(user.getCreateTime())
                    .build();
            userInfoList.add(userInfo);
        }
        return userInfoList;
    }

}