package com.example.AuthApplication.service;

import com.example.AuthApplication.domain.Customer;
import com.example.AuthApplication.exception.CustomerAlreadyExistException;
import com.example.AuthApplication.exception.CustomerNotFoundException;
import org.apache.catalina.User;

import java.util.List;

public interface ICustomerService {
    public Customer customerRegister(Customer customer) throws CustomerAlreadyExistException;
    public Customer customerLogin(Customer customer) throws CustomerNotFoundException;
}
