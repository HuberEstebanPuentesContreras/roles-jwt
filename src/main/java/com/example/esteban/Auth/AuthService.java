package com.example.esteban.Auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.esteban.Entity.Role;
import com.example.esteban.Entity.User;
import com.example.esteban.IRepository.UserIRepository;
import com.example.esteban.Jwt.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
	
	private final UserIRepository iRepositoryUsuario;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        User email=iRepositoryUsuario.findByEmail(request.getEmail()).orElseThrow();
        String token=jwtService.getToken(email);
        return AuthResponse.builder()
            .token(token)
            .build();

    }
    
    public AuthResponse registerUser(RegisterRequest request) {
        User user = User.builder()
            .name(request.getName())
            .lastName(request.getLastName())
            .documentType(request.getDocumentType())
            .documentNumber(request.getDocumentNumber())
            .age(request.getAge())
            .phoneNumber(request.getPhoneNumber())           
            .email(request.getEmail())
            .Password(passwordEncoder.encode( request.getPassword()))
            .role(Role.USER)
            .build();

        iRepositoryUsuario.save(user);

        return AuthResponse.builder()
            .token(jwtService.getToken(user))
            .build();
        
    }
    
    public AuthResponse registerAdmin(RegisterRequest request) {
        User user = User.builder()
            .name(request.getName())
            .lastName(request.getLastName())
            .documentType(request.getDocumentType())
            .documentNumber(request.getDocumentNumber())
            .age(request.getAge())
            .phoneNumber(request.getPhoneNumber())           
            .email(request.getEmail())
            .Password(passwordEncoder.encode( request.getPassword()))
            .role(Role.ADMIN)
            .build();

        iRepositoryUsuario.save(user);

        return AuthResponse.builder()
            .token(jwtService.getToken(user))
            .build();
        
    }

}
