package com.desafio.recruta.service;

import java.util.List;
import java.util.Optional;

import com.desafio.recruta.entity.User;

public interface UserService {

    User createUser(User user);

    Optional<User> findByUsername(String username);

    List<User> findAll();
}
