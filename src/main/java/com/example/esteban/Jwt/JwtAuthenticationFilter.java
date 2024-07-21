package com.example.esteban.Jwt;

import java.io.IOException;


import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


import org.springframework.util.StringUtils;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter{

	private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
 
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
       
    	//Obtener token
        final String token = getTokenFromRequest(request);
        final String email;

        //Si no hay token, continuar con el siguiente filtro 
        if (token==null)
        {
            filterChain.doFilter(request, response);
            return;
        }

        //obtener email del token
        email=jwtService.getUsernameFromToken(token);
        
        

        if (email!=null && SecurityContextHolder.getContext().getAuthentication()==null)
        {
        	//Carga detalles de usuario usnado el email
            UserDetails userDetails=userDetailsService.loadUserByUsername(email);
            //Verificar si token es valido
            if (jwtService.isTokenValid(token, userDetails))
            {
            	//crear un token de autenticacion
                UsernamePasswordAuthenticationToken authToken= new UsernamePasswordAuthenticationToken(
                    userDetails,
                    null,
                    userDetails.getAuthorities());
                	

                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                //Establecer autenticacion
                SecurityContextHolder.getContext().setAuthentication(authToken);
               
            }

        }
        
        filterChain.doFilter(request, response);
    }
    
    //Metodo para obtener el token del encabezado de la solicitud
    private String getTokenFromRequest(HttpServletRequest request) {
        final String authHeader=request.getHeader(HttpHeaders.AUTHORIZATION);

        //Verificar si el encabezado contiene texto y comienza con "Bearer "
        if(StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer "))
        {
        	//Retornar el token sin el prefijo "Bearer "
            return authHeader.substring(7);
        }
        return null;
    }
}
