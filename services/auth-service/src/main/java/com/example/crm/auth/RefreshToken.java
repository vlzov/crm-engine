package com.example.crm.auth;
import jakarta.persistence.*; import lombok.*; import java.time.Instant; import java.util.*;
@Entity @Getter @Setter @NoArgsConstructor public class RefreshToken { @Id @GeneratedValue(strategy=GenerationType.UUID) UUID id; @Column(unique=true,nullable=false) String token; @ManyToOne(optional=false) UserAccount user; @Column(nullable=false) Instant expiresAt; boolean revoked; public RefreshToken(String t,UserAccount u,Instant e){token=t;user=u;expiresAt=e;} }
