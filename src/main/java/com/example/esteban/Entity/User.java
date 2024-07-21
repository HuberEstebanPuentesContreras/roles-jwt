package com.example.esteban.Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user")
public class User implements Serializable, UserDetails {

	private final static long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	

	@Column(name = "name", length = 50, nullable = false)
	private String name;
	
	@Column(name = "last_name", length = 50, nullable = false)
	private String lastName;
	
	@Column(name = "document_type", length = 20, nullable = false)
	private String documentType;
	
	@Column(name = "document_number", unique = true, length = 20, nullable = false)
	private String documentNumber;
	
	@Column(name = "age", length = 3, nullable = false)
	private String age;
		
	@Column(name = "phone_number", length = 20, nullable = false)
	private String phoneNumber;
	
	@Column(name = "email", nullable = false, unique = true,  length = 50)
	private String email;
	
	@Column(name ="password", nullable = false, length = 128) 
	private String Password;
	
	@Enumerated(EnumType.STRING)
    @Column(name ="role", length = 20, nullable = false)
    private Role role;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority((role.name())));
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String getUsername() {
		return this.email;
	}
	
	
}
