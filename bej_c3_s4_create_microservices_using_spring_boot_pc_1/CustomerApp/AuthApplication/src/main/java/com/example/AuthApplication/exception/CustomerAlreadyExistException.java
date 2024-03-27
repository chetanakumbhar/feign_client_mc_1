package com.example.AuthApplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.ALREADY_REPORTED,reason = "customer is already exist with this name..")
public class CustomerAlreadyExistException extends Exception{
}
