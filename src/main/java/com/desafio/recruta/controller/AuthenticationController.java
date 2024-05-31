package com.desafio.recruta.controller;

import com.desafio.recruta.config.TokenService;
import com.desafio.recruta.dto.AuthenticationDTO;
import com.desafio.recruta.dto.LoginResponseDTO;
import com.desafio.recruta.dto.RegisterDTO;
import com.desafio.recruta.entity.Job;
import com.desafio.recruta.entity.User;
import com.desafio.recruta.repository.UserRepository;
import com.desafio.recruta.service.AuthorizationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private TokenService tokenService;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationDTO authenticationDTO) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(authenticationDTO.username(), authenticationDTO.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((User) auth.getPrincipal());
        var user = authorizationService.findUserByUsername(authenticationDTO.username());

        return ResponseEntity.ok(new LoginResponseDTO(token, user.getRole().getRole(), user.getId(), user.getUsername()));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterDTO registerDTO) {
        if(this.userRepository.findByUsername(registerDTO.username()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDTO.password());

        User newUser = new User(
            registerDTO.username(),
            encryptedPassword,
            registerDTO.role(),
            registerDTO.name(),
            registerDTO.email()
        );
        this.userRepository.save(newUser);
        
        return ResponseEntity.ok().build();
    }

    
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return authorizationService.getUserById(id)
                .map(user -> ResponseEntity.ok().body(new User(
                    user.getId(),
                    user.getUsername(),
                    null,
                    user.getRole(),
                    user.getName(),
                    user.getEmail()
                )))
                .orElse(ResponseEntity.notFound().build());
    }

}
