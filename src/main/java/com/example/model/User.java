package com.example.model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
public class User {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 20, message = "Name should be between 2 and 30 characters")
    private String name;

    @Min(value = 0, message = "Age should be greater than 0")
    private String age;

    @Email(message = "Email should be valid")
    @NotEmpty(message = "Email should not be empty")
    private String email;

    public @NotEmpty(message = "Name should not be empty")
            @Size(min = 2, max = 20, message = "Name should be between 2 and 30 characters")
            String getName() {
        return name;
    }

    public void setName(@NotEmpty(message = "Name should not be empty")
                        @Size(min = 2, max = 20, message = "Name should be between 2 and 30 characters")
                        String name) {
        this.name = name;
    }

    public @Min(value = 0, message = "Age should be greater than 0")
            String getAge() {
        return age;
    }

    public void setAge(@Min(value = 0, message = "Age should be greater than 0")
                       String age) {
        this.age = age;
    }

    public @Email(message = "Email should be valid")
            @NotEmpty(message = "Email should not be empty")
            String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "Email should be valid")
                         @NotEmpty(message = "Email should not be empty")
                         String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User: id = " + id + ", name = '" + name + "', age = '"
                + age + "', email = '" + email + "'";
    }
}