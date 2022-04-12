package com.example.rabbitmqdemo.RabbitMQConfig;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class QueueConfig {

    public static final String QUEUE = "Cola_Mensaje1";
    public static final String EXCHANGE = "Cola_Exchange";
    public static final String ROUTING_KEY = "Cola_Llave";
    //establecemos una cola nueva en rabbit MQ bajo el nombre de Cola_Mensaje1
    @Bean
    public Queue queue(){
        return new Queue(QUEUE);
    }
    //Establecemos el gateway exchange que definira la ruta
    // por donde enviara el mensaje de acuerdo al router key que le configuremos
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(EXCHANGE);

    }

    //Inicializamos la cola con el topic exchange y definimos la llave por
    //donde enviaremos el mensaje
    @Bean
    public Binding binding(Queue queue,TopicExchange topicExchange){

        return BindingBuilder
                .bind(queue)
                .to(topicExchange)
                .with(ROUTING_KEY);
    }
    //Tranformamos el mensaje de la cola a formato json para su lectura
    @Bean
    public MessageConverter messageConverter(){

        return new Jackson2JsonMessageConverter();
    }
    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory){
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }

}
