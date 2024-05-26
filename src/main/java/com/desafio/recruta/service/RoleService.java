package com.desafio.recruta.service;

import java.util.List;
import java.util.Optional;

import com.desafio.recruta.entity.Role;

public interface RoleService {

    Role createRole(Role role);

    Optional<Role> findByName(String name);

    List<Role> findAll();
}
