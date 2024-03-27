package com.example.AuthApplication.repository;

import com.example.AuthApplication.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User,String> {
    public User findByEmailAndPassword(String email,String password);
//    public User findByEmail(String email);
}
