package io.github.sztuwebclub.webvoyager.domain.user;

public interface IUserRepo {
    UserAuth getUserAuthByUsername(String username);
}
