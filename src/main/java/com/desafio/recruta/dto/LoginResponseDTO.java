package com.desafio.recruta.dto;

import com.desafio.recruta.entity.User;

public record LoginResponseDTO(String token, String role, Long idUser, String username) {
}
