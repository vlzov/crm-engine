package com.example.crm.customer;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;
import java.util.UUID;

@Entity @Getter @Setter @NoArgsConstructor
public class Customer {
  @Id @GeneratedValue(strategy = GenerationType.UUID) private UUID id;
  @Column(nullable=false) private String name;
  private String email;
  private String phone;
  @Column(nullable=false, updatable=false) private Instant createdAt;
  @PrePersist void onCreate(){ createdAt=Instant.now(); }
  public Customer(String name,String email,String phone){this.name=name;this.email=email;this.phone=phone;}
}
