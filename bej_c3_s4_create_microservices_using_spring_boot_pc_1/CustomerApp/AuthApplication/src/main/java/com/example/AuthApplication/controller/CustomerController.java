package com.example.AuthApplication.controller;

import com.example.AuthApplication.domain.Customer;
import com.example.AuthApplication.exception.CustomerAlreadyExistException;
import com.example.AuthApplication.exception.CustomerNotFoundException;
import com.example.AuthApplication.service.ICustomerService;
import com.example.AuthApplication.service.SecurityTokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer/v1")
public class CustomerController {
    @Autowired
    ICustomerService iCustomerService;
    @Autowired
    SecurityTokenGenerator securityTokenGenerator;

    //    http://localhost:65500/api/customer/v1/register-customer
    @PostMapping("/register-customer")
    public ResponseEntity registerCustomer(@RequestBody Customer customer) throws CustomerAlreadyExistException {
        return new ResponseEntity<>(iCustomerService.customerRegister(customer), HttpStatus.CREATED);
    }

    //    http://localhost:65500/api/customer/v1/login-customer
    @GetMapping("/login-customer")
    public ResponseEntity CustomerLogin(@RequestBody Customer customer) throws CustomerNotFoundException {
        Customer insertDetails = iCustomerService.customerLogin(customer);
        if(insertDetails != null) {
            return new ResponseEntity<>(securityTokenGenerator.generateToken(insertDetails), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Login Failed...",HttpStatus.EXPECTATION_FAILED);
        }
    }
}
