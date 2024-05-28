package com.desafio.recruta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.desafio.recruta.entity.User;


public interface UserRepository extends JpaRepository<User, Long>{
    UserDetails findByUsername(String username);
}
