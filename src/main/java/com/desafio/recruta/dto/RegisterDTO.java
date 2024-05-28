package com.desafio.recruta.dto;

import com.desafio.recruta.enums.UserRole;

public record RegisterDTO(String username, String password, UserRole role, String name, String email) {
}
