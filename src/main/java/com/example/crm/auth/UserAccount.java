package com.example.crm.auth;
import jakarta.persistence.*; import lombok.*; import java.util.*;
@Entity @Table(name="users") @Getter @Setter @NoArgsConstructor public class UserAccount { @Id @GeneratedValue(strategy=GenerationType.UUID) UUID id; @Column(unique=true,nullable=false) String username; @Column(nullable=false) String passwordHash; @Enumerated(EnumType.STRING) @Column(nullable=false) Role role; boolean enabled=true; public UserAccount(String u,String p,Role r){username=u;passwordHash=p;role=r;} }
