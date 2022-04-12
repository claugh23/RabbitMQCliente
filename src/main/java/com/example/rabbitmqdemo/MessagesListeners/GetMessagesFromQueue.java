package com.example.rabbitmqdemo.MessagesListeners;

import com.example.rabbitmqdemo.Model.UserDTO;
import com.example.rabbitmqdemo.RabbitMQConfig.QueueConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetMessagesFromQueue {

    private List<UserDTO> ListMessages;
    @RabbitListener(queues = QueueConfig.QUEUE)
    public List<UserDTO> listener(UserDTO message) {

        ListMessages.add(message);

        return ListMessages;
    }
}
