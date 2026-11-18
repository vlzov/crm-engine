package com.example.crm.customer;
import java.time.Instant; import java.util.UUID;
public record CustomerDto(UUID id,String name,String email,String phone,Instant createdAt) {}
