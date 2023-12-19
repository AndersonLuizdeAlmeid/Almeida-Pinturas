package com.almeida.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.almeida.project.entities.UserEntity;
import com.almeida.project.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public ResponseEntity<Boolean> getUser(UserEntity user) {
        try {
            if (userRepository.getValueById(user.getEmail()).equals(null))
                return ResponseEntity.ok(false);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(true);
    }
}
