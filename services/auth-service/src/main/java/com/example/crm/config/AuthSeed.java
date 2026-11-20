package com.example.crm.auth;
import org.springframework.beans.factory.annotation.Value; import org.springframework.boot.CommandLineRunner; import org.springframework.context.annotation.*; import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration public class AuthSeed {
 @Bean CommandLineRunner seed(UserRepository r, PasswordEncoder e,
   @Value("${app.seed.client.username}") String cu,@Value("${app.seed.client.password}") String cp,
   @Value("${app.seed.operator.username}") String ou,@Value("${app.seed.operator.password}") String op,
   @Value("${app.seed.admin.username}") String au,@Value("${app.seed.admin.password}") String ap){return a->{seed(r,e,cu,cp,Role.CLIENT);seed(r,e,ou,op,Role.OPERATOR);seed(r,e,au,ap,Role.ADMIN);};} private void seed(UserRepository r,PasswordEncoder e,String u,String p,Role role){var x=r.findByUsername(u).orElseGet(()->new UserAccount(u,"",role));x.setPasswordHash(e.encode(p));x.setRole(role);x.setEnabled(true);r.save(x);}
}
