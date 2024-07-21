package com.example.esteban.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.esteban.Jwt.JwtAuthenticationFilter;

import lombok.RequiredArgsConstructor;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	//Configuracion de Spring Security
	
	private final JwtAuthenticationFilter jwtAuthenticationFilter;
	private final AuthenticationProvider authProvider;

	@Bean 
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
		return http
	            .csrf(csrf -> 
	                csrf
	                .disable())
	            .authorizeHttpRequests(authorize -> authorize
	            		
	            	  //Proteccion de rutas por roles
		              .requestMatchers("/api/auth/**").permitAll()
		              
		              .requestMatchers(HttpMethod.POST, "/api/security/schedule/generate").hasAuthority("ADMIN")
		              .requestMatchers(HttpMethod.GET,"/api/security/schedule/get").hasAnyAuthority("ADMIN", "USER", "STUDENT", "TEACHER")
		              .requestMatchers(HttpMethod.GET,"/api/security/schedule/getId/**").hasAnyAuthority("ADMIN", "USER", "STUDENT", "TEACHER")
		              
		              .requestMatchers(HttpMethod.GET,"/api/security/user/**").hasAnyAuthority("ADMIN", "USER", "STUDENT", "TEACHER")
		              .requestMatchers(HttpMethod.PUT, "/api/security/user/**").hasAnyAuthority("ADMIN", "TEACHER")
		              .requestMatchers(HttpMethod.DELETE, "/api/security/user/**").hasAuthority("ADMIN")
		              
		              .requestMatchers(HttpMethod.POST, "/api/security/teacher").hasAnyAuthority("ADMIN", "TEACHER")
		              .requestMatchers(HttpMethod.GET,"/api/security/teacher").hasAnyAuthority("ADMIN", "TEACHER")
		              .requestMatchers(HttpMethod.GET,"/api/security/teacher/**").hasAnyAuthority("ADMIN", "TEACHER")
		              .requestMatchers(HttpMethod.PUT, "/api/security/teacher/**").hasAnyAuthority("ADMIN", "TEACHER")
		              .requestMatchers(HttpMethod.DELETE, "/api/security/teacher/**").hasAnyAuthority("ADMIN", "TEACHER")
		              
		              .requestMatchers(HttpMethod.POST, "/api/security/course").hasAuthority("ADMIN")
		              .requestMatchers(HttpMethod.GET,"/api/security/course").hasAuthority("ADMIN")
		              .requestMatchers(HttpMethod.GET,"/api/security/course/**").hasAuthority("ADMIN")
		              .requestMatchers(HttpMethod.PUT, "/api/security/course/**").hasAuthority("ADMIN")
		              .requestMatchers(HttpMethod.DELETE, "/api/security/course/**").hasAuthority("ADMIN")
		              
		              .requestMatchers(HttpMethod.POST, "/api/security/specialty").hasAuthority("ADMIN")
		              .requestMatchers(HttpMethod.GET,"/api/security/specialty").hasAnyAuthority("ADMIN", "TEACHER")
		              .requestMatchers(HttpMethod.GET,"/api/security/specialty/**").hasAuthority("ADMIN")
		              .requestMatchers(HttpMethod.PUT, "/api/security/specialty/**").hasAuthority("ADMIN")
		              .requestMatchers(HttpMethod.DELETE, "/api/security/specialty/**").hasAuthority("ADMIN")
		              
		              .requestMatchers(HttpMethod.GET,"/api/security/assingrole").hasAuthority("ADMIN")
		              .requestMatchers(HttpMethod.GET,"/api/security/assingrole/**").hasAuthority("ADMIN")
		              .requestMatchers(HttpMethod.PUT, "/api/security/assingrole/**").hasAuthority("ADMIN")
		              
	                .anyRequest().authenticated()
	                )
	            .sessionManagement(sessionManager->
	                sessionManager 
	                  .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	            .authenticationProvider(authProvider)
	            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
	            .build();
                        
    }
}

