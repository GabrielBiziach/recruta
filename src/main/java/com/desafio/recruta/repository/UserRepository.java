package com.desafio.recruta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.desafio.recruta.entity.User;


public interface UserRepository extends JpaRepository<User, Long>{

    User findByUsername(String username);
}
