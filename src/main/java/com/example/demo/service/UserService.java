package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {

    User registerUser(User user);

    User getByEmail(String email);

    User getUser(Long id);
}
