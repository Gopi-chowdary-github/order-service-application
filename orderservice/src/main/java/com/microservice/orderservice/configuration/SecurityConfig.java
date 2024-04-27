package com.microservice.orderservice.configuration;


import com.microservice.orderservice.repository.UserRepository;
import com.microservice.orderservice.security.UserDetailsImpl;
import com.microservice.orderservice.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {


    @Autowired
    UserRepository userRepository;
    @Bean
    public UserDetailsService userDetailsService(){

       return new UserDetailsServiceImpl();
    }

   @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
     return  http
               .authorizeHttpRequests((requests) -> requests
                       .requestMatchers("/user/**","/customactuator/**","/city/addCities","customer/addCustomer").permitAll()
                       .requestMatchers("/customer/**").authenticated()

               ).csrf()
                .disable()
                .formLogin().and()
               .build();


    }

  @Bean
  public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(encoder());
        authenticationProvider.setUserDetailsService(userDetailsService());

        return authenticationProvider;
    }

   @Bean
   public PasswordEncoder encoder(){
        return  new BCryptPasswordEncoder();
    }
}
