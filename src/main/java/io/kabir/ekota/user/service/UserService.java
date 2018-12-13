package io.kabir.ekota.user.service;

import io.kabir.ekota.user.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();

    User findByUsername(String userName);
}
