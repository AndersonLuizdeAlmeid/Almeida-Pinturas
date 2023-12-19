package com.almeida.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.almeida.project.entities.UserEntity;
import com.almeida.project.services.UserService;

@RestController
@RequestMapping(value = "/login")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping()
    public ResponseEntity<String> login(@RequestBody UserEntity login) {
        if (userService.getUser(login).equals(null))
            return ResponseEntity.ok("Email ou senha incorretos.");
        return ResponseEntity.ok("Ok.");
    }

}
