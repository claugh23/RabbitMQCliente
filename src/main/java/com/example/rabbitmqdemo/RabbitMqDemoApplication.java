package com.example.rabbitmqdemo;

import com.example.rabbitmqdemo.Model.UserDTO;
import com.example.rabbitmqdemo.RabbitMQConfig.QueueConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.rabbitmqdemo.*"})
public class RabbitMqDemoApplication {



    public static void main(String[] args) {
        SpringApplication.run(RabbitMqDemoApplication.class, args);
    }

    @RabbitListener(queues = QueueConfig.QUEUE)
    public void listener(UserDTO message) {
        try{
            System.out.println(message);
        }catch (Exception errorListener){
            throw errorListener;
        }
    }
}
