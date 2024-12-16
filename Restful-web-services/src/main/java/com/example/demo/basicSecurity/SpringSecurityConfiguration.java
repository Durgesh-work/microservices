package com.example.demo.basicSecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

	    // Allow requests to be authenticated
	    http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());

	    // Use HTTP Basic Authentication
	    http.httpBasic(withDefaults());

	    // Disable form-based login
	    http.formLogin().disable();

	    // Disable CSRF for simplicity (only for testing or APIs)
	    http.csrf().disable();

	    return http.build();
	}
}
