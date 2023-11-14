package com.almeida.producerservice.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserEntity implements Serializable {

    private String id;
    private String name;
    private String idade;

}
