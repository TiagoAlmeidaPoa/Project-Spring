package com.almeida.producerservice.entities;

import lombok.Data;

import java.io.Serializable;
@Data
public class OrderEntity implements Serializable {

    private String name;
    private String type;
    private String status;

}
