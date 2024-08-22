package com.example.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String age;
    private String email;

    @Override
    public String toString() {
        return "User: id = " + id + ", name = '" + name + "', age = '"
                + age + "', email = '" + email + "'";
    }
}