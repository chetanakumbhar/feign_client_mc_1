package com.example.AuthApplication.service;

import com.example.AuthApplication.domain.User;
import com.example.AuthApplication.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    IUserRepository iUserRepository;
    @Override
    public User register(User user) {
        return iUserRepository.save(user);
    }

    @Override
    public User checkLogin(User user) {
        return iUserRepository.findByEmailAndPassword(user.getEmail(),user.getPassword());
    }

    @Override
    public User findByEmail(String email) {
        return iUserRepository.findById(email).get();
    }
}
