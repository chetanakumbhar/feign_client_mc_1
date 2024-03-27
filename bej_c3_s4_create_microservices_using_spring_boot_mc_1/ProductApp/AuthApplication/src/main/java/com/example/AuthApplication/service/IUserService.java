package com.example.AuthApplication.service;

import com.example.AuthApplication.domain.User;

public interface IUserService {
    public User register(User user);
    public User checkLogin(User user);
    public User findByEmail(String email);

}
