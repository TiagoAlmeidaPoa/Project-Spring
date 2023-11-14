package com.almeida.producerservice.configs;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfigs {

    public static final String EXG_CREATE_USER = "create_user.direct";
    public static final String QUEUE_CREATE_USER_LOG = "create_user.log";
    public static final String RK_CREATE_USER = "create_user.log";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_CREATE_USER_LOG, false, false, false);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(EXG_CREATE_USER, false, false);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder
            .bind(queue())
            .to(directExchange())
            .with(RK_CREATE_USER);
    }

}
