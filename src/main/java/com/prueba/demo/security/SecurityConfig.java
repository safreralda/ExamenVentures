package com.prueba.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity


public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Deshabilita CSRF utilizando la nueva forma
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/**").authenticated()  // Utiliza requestMatchers en lugar de antMatchers
                        .anyRequest().permitAll())
                .httpBasic(withDefaults());  // Configura httpBasic con withDefaults
        return http.build();
    }
}

