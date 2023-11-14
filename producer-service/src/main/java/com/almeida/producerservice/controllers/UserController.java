package com.almeida.producerservice.controllers;

import com.almeida.producerservice.entities.UserEntity;
import com.almeida.producerservice.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserController {

    private final UserService service;

    @PostMapping
    public ResponseEntity<String> sendUser(@RequestBody UserEntity userEntity) {
        service.createUser(userEntity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
