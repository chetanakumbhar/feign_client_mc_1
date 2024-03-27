package com.example.AuthApplication.repository;

import com.example.AuthApplication.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
    public Customer findByCustomerIdAndCustomerPassword(int customerId,String customerPassword);
}
