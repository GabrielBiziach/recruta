package com.desafio.recruta.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class TestSecurityController {

    @GetMapping
    public String auth(){
        return "Autorizado";
    }
}