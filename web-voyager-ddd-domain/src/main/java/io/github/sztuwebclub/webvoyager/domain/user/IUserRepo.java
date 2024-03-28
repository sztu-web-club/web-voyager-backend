package io.github.sztuwebclub.webvoyager.domain.user;

import java.util.List;

public interface IUserRepo {
    UserAuth getUserAuthByUsername(String username);

    List<User> getUserList();
}
