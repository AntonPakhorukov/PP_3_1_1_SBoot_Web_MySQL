package com.example.service;

import com.example.model.User;
import com.example.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Transactional
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public void updateUser(User user) {
        User updateUser = userRepository.findById(user.getId()).get();
        updateUser.setName(user.getName());
        updateUser.setAge(user.getAge());
        updateUser.setEmail(user.getEmail());
        userRepository.save(updateUser);
    }

    @Transactional
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}