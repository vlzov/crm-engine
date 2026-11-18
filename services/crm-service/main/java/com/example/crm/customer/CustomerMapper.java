package com.example.crm.customer;
import org.springframework.stereotype.Component;
@Component public class CustomerMapper { public CustomerDto toDto(Customer c){return new CustomerDto(c.getId(),c.getName(),c.getEmail(),c.getPhone(),c.getCreatedAt());} public Customer toEntity(String n,String e,String p){return new Customer(n,e,p);} public void update(Customer c,String n,String e,String p){c.setName(n);c.setEmail(e);c.setPhone(p);} }
