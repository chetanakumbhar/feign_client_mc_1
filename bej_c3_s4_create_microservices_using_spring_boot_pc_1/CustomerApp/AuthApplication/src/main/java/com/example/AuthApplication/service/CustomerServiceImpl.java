package com.example.AuthApplication.service;

import com.example.AuthApplication.domain.Customer;
import com.example.AuthApplication.exception.CustomerAlreadyExistException;
import com.example.AuthApplication.exception.CustomerNotFoundException;
import com.example.AuthApplication.repository.ICustomerRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements ICustomerService{
    @Autowired
    ICustomerRepository iCustomerRepository;
    @Override
    public Customer customerRegister(Customer customer)throws CustomerAlreadyExistException {
        return iCustomerRepository.save(customer);
    }

    @Override
    public Customer customerLogin(Customer customer) throws CustomerNotFoundException{
        return iCustomerRepository.findByCustomerIdAndCustomerPassword(customer.getCustomerId(), customer.getCustomerPassword());
    }
}
