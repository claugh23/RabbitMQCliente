# RabbitMQTest

Instrucciones:

1. Execute RabbitMQ Server and started the web controller with the url:  http://localhost:15672 (port number might be change) default credentials: guest/guest
2. Generate request with Postman by using this url:  http://localhost:3400/api/v1/PublisherMessage/publish/ this request recive a @RequestBody DTO json model
4. User DTO Model :
5. {
    "id":0,
    "name":"test",
    "lastName":"test",
    "phone":11112222
    }
6. Messages from rabbitMQ should be displayed in the line console of the application 

