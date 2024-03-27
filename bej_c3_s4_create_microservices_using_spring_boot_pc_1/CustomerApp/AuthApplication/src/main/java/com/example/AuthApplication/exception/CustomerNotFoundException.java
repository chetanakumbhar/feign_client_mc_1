package com.example.AuthApplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "customer is not found with provided details..")
public class CustomerNotFoundException extends Exception{
}
