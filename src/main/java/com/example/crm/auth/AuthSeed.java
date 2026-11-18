package com.example.crm.auth;
import org.springframework.beans.factory.annotation.Value; import org.springframework.boot.CommandLineRunner; import org.springframework.context.annotation.*; import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration public class AuthSeed {
 @Bean CommandLineRunner seed(UserRepository r, PasswordEncoder e,
   @Value("${app.seed.client.username}") String cu,@Value("${app.seed.client.password}") String cp,
   @Value("${app.seed.operator.username}") String ou,@Value("${app.seed.operator.password}") String op,
   @Value("${app.seed.admin.username}") String au,@Value("${app.seed.admin.password}") String ap){return a->{if(r.count()==0){r.save(new UserAccount(cu,e.encode(cp),Role.CLIENT));r.save(new UserAccount(ou,e.encode(op),Role.OPERATOR));r.save(new UserAccount(au,e.encode(ap),Role.ADMIN));}};}
}
