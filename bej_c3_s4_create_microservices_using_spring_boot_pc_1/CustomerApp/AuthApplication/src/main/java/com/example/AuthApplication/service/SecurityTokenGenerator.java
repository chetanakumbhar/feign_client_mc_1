package com.example.AuthApplication.service;

import com.example.AuthApplication.domain.Customer;

import java.util.Map;

public interface SecurityTokenGenerator {
    public Map<String,String> generateToken(Customer customer);
}
