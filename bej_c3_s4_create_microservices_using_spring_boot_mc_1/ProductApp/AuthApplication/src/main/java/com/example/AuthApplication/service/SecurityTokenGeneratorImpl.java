package com.example.AuthApplication.service;

import com.example.AuthApplication.domain.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Service
public class SecurityTokenGeneratorImpl implements SecurityTokenGenerator{
    @Override
    public Map<String, String> generateToken(User user) {
        Map<String,String> result = new HashMap<>();      //obj of map
        Map<String,Object> userdata = new HashMap<>();
        userdata.put("userEmail",user.getEmail());
        userdata.put("role",user.getRole());
        String myToken = Jwts.builder()
                .setClaims(userdata)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512,"secretKey55")
                .compact();
        result.put("Token",myToken);
        result.put("Message","User LoggedIn Successfully.." );
        return result;
    }
}
