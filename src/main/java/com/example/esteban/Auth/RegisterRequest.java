package com.example.esteban.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
	String name;
    String lastName;
    String documentType;
    String documentNumber;
    String age;
    String phoneNumber;
    String email;
    String password;
}
