package com.example.rabbitmqdemo.Controllers;

import com.example.rabbitmqdemo.MessagesListeners.GetMessagesFromQueue;
import com.example.rabbitmqdemo.Model.UserDTO;
import com.example.rabbitmqdemo.RabbitMQConfig.QueueConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("api/v1/PublisherMessage")
public class PublisherController {

    @Autowired
    private RabbitTemplate template;

    private GetMessagesFromQueue messagesFromRabbitMQ;

    @PostMapping("/publish")
    public String postMessage(@RequestBody UserDTO message){

        if (message.getId() == 0 || message == null){
            message.setId((int) (Math.random() * 10000));
            template.convertAndSend(QueueConfig.EXCHANGE,QueueConfig.ROUTING_KEY,message);

            return "El mensaje ha sido enviado a Rabbit MQ";
        }else{
            return "Ocurrio un error al enviar el mensaje, verifica el objeto enviado";
        }
    }


}
