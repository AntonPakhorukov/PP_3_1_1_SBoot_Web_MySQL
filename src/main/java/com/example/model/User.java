package com.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @NotEmpty(message = "Name should not be empty")
//    @Size(min = 2, max = 20, message = "Name should be between 2 and 30 characters")
    private String name;
//    @Min(value = 0, message = "Age should be greater than 0")
    private String age;
//    @Email(message = "Email should be valid")
//    @NotEmpty(message = "Email should not be empty")
    private String email;

    @Override
    public String toString() {
        return "User: id = " + id + ", name = '" + name + "', age = '"
                + age + "', email = '" + email + "'";
    }
}