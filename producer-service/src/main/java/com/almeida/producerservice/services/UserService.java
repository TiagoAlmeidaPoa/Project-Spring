package com.almeida.producerservice.services;

import com.almeida.producerservice.entities.UserEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static com.almeida.producerservice.configs.RabbitMQConfigs.EXG_CREATE_USER;
import static com.almeida.producerservice.configs.RabbitMQConfigs.RK_CREATE_USER;

@Log4j2
@RequiredArgsConstructor
@Service
public class UserService {

    private final RabbitTemplate rabbitTemplate;

    @SneakyThrows
    public void createUser(UserEntity userEntity){
        String messsage = new ObjectMapper().writeValueAsString(userEntity);
        log.info("Received message " + userEntity);
        rabbitTemplate.convertAndSend(EXG_CREATE_USER, RK_CREATE_USER, messsage);
    }

}
