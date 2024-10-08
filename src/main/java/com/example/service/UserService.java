package com.example.service;

import com.example.model.User;

import java.util.List;

public interface UserService {
    User findById(Long id);
    List<User> findAll();
    User saveUser(User user);
    void updateUser(User user);
    void deleteById(Long id);
}
