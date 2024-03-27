package com.example.AuthApplication.service;

import com.example.AuthApplication.domain.Customer;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Service
public class SecurityTokenGeneratorImpl implements SecurityTokenGenerator{
    @Override
    public Map<String, String> generateToken(Customer customer) {
        Map<String, String> result = new HashMap<>();
        Map<String, Object> customerData = new HashMap<>();
        customerData.put("customerId",customer.getCustomerId());
        String myToken = Jwts.builder()
                .setClaims(customerData)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512,"securityKey123")
                .compact();
        result.put("message","Customer Logged In Successfully....");
        result.put("Token",myToken);
        return result;
    }
}
