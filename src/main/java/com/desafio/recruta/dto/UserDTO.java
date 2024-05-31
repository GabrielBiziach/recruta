package com.desafio.recruta.dto;

import com.desafio.recruta.enums.UserRole;

public record UserDTO(String username, String password, UserRole role, String name, String email) {

}
