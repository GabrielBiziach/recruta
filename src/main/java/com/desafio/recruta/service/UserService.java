package com.desafio.recruta.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.desafio.recruta.entity.User;
import com.desafio.recruta.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // public User createUser(User user) {
    //     User existUser = userRepository.findByUsername(user.getUsername());

    //     if(existUser != null) throw new Error("Usuário já existe");

    //     user.setPassword(passwordEncoder().encode(user.getPassword()));
    //     User createdUser = userRepository.save(user);

    //     return createdUser;
    // }

    // public Optional<User> findByUsername(String username) {
    //     return Optional.ofNullable(userRepository.findByUsername(username));
    // }

    public List<User> findAll() {
       return userRepository.findAll();
    }
}
