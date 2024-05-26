package com.desafio.recruta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.recruta.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

    Role findByName(String name);
}
