package io.github.sztuwebclub.webvoyager.domain.user;

import java.util.List;

public interface IUserRepo {
    Integer userCount(String title);

    List<User> pageQuery(Integer start, Integer pagesize, String title);

    User getUserById(Integer id);

    UserAuth getUserAuthByUsername(String username);

}
