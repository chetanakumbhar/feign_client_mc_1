package com.example.AuthApplication.controller;

import com.example.AuthApplication.domain.User;
import com.example.AuthApplication.service.IUserService;
import com.example.AuthApplication.service.SecurityTokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/v1")
public class UserController {
    @Autowired
    IUserService iUserService;
    @Autowired
    SecurityTokenGenerator securityTokenGenerator;

    //          http://localhost:8085/api/user/v1/user-register      [post]
    @PostMapping("/user-register")
    public ResponseEntity registerUser(@RequestBody User user)
    {
        user.setRole("User-Role");
        return new ResponseEntity<>(iUserService.register(user), HttpStatus.CREATED);
    }

    //         http://localhost:8085/api/user/v1/user-login
    @GetMapping("/user-login")
    public ResponseEntity Login(@RequestBody User user)
    {
        User retrievedDetails = iUserService.checkLogin(user);
        System.out.println(retrievedDetails);
        if(retrievedDetails != null)
        {
            return new ResponseEntity<>(securityTokenGenerator.generateToken(retrievedDetails),HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Login Failed...",HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/user/{email}")
    public ResponseEntity findByEmail(@PathVariable String email){
        return new ResponseEntity<>(iUserService.findByEmail(email),HttpStatus.OK);
    }

}
