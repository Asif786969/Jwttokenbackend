package com.auth.authbackend.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


@Document(collection = "users")
public class User {
    @Id
    private String userid;
    private String username;
    private String password;
    private String role;
}
