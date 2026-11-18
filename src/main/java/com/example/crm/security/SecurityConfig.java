package com.example.crm.security;
import org.springframework.context.annotation.*; import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity; import org.springframework.security.config.annotation.web.builders.HttpSecurity; import org.springframework.security.core.userdetails.*; import org.springframework.security.provisioning.InMemoryUserDetailsManager; import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import org.springframework.security.crypto.password.PasswordEncoder; import org.springframework.security.web.SecurityFilterChain;
@Configuration @EnableMethodSecurity public class SecurityConfig {
 @Bean PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();}
 @Bean UserDetailsService users(PasswordEncoder e){return new InMemoryUserDetailsManager(
  User.withUsername("client").password(e.encode("client123")).roles("CLIENT").build(),
  User.withUsername("operator").password(e.encode("operator123")).roles("OPERATOR").build(),
  User.withUsername("admin").password(e.encode("admin123")).roles("ADMIN").build());}
 @Bean SecurityFilterChain filter(HttpSecurity http) throws Exception {return http.csrf(c->c.disable()).authorizeHttpRequests(a->a.requestMatchers("/actuator/health","/actuator/info").permitAll().anyRequest().authenticated()).httpBasic(h->{}).build();}
}
