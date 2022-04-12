package com.example.rabbitmqdemo.Model;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDTO {

    private int id;
    private String name;
    private String lastName;
    private int phone;
}
