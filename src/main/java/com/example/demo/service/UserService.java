package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {
    User createUser(User user);
    User getUserById(Long id);
}
