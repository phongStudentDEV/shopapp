package com.project.shopapp.configurations;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig {
    //Lọc đầu vào request
  @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws  Exception{
         http.csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(request ->{
                request.requestMatchers("**").permitAll();
            })
         ;
         return http.build();
    }
}
