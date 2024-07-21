package com.example.esteban.Jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.esteban.Entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	@Value("${jwt.secret}")
	private String SECRET_KEY;

	//Metodo publico para obtener un token para un usuario
    public String getToken(User user) {
        return getToken(new HashMap<>(), user);
    }

    //Metodo privado para generar un token personalizado (claims)
    private String getToken(Map<String,Object> extraClaims, User user) {
        return Jwts
            .builder()
            .claims(extraClaims)
            .claim("role",user.getRole())
            .subject(user.getEmail())
            .issuedAt(new Date(System.currentTimeMillis()))
            .expiration(new Date(System.currentTimeMillis()+ 1000 * 60 * 24))
            .signWith(getKey())
            .compact();
    }
    
    //Metodo privado para obtener la clave secreta decodificada y convertirla en una clave de firma
    private SecretKey getKey() {
        byte[] keyBytes=Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    
    //Metodo para obtener el email del token
    public String getUsernameFromToken(String token) {
        return getClaim(token, Claims::getSubject);
    }

    //Metodo para verificar si un token es valido
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username=getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername())&& !isTokenExpired(token));
    }

    //Metodo privado para obtener todos los claims del token
    private Claims getAllClaims(String token)
    {
        return Jwts
            .parser()
            .verifyWith(getKey())
            .build()
            .parseSignedClaims(token)
            .getPayload();
    }

    //Metodo para obtener todos los cleims especificos del token
    public <T> T getClaim(String token, Function<Claims,T> claimsResolver)
    {
        final Claims claims=getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    //Metodo para obtener la fecha de expiracion del token
    private Date getExpiration(String token)
    {
        return getClaim(token, Claims::getExpiration);
    }

    //Metodo privado pra verificar si un token ha expirado
    private boolean isTokenExpired(String token)
    {
        return getExpiration(token).before(new Date());
    }
}
