package com.promanage.user.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            try {
                String token = authHeader.substring(7);
                HttpHeaders headers = new HttpHeaders();
                headers.set("Authorization", "Bearer " + token);
                HttpEntity<Void> entity = new HttpEntity<>(headers);

                ResponseEntity<Void> result = restTemplate.exchange(
                        "http://auth-service:8080/api/auth/validate",
                        HttpMethod.POST,
                        entity,
                        Void.class
                );

                if (!result.getStatusCode().is2xxSuccessful()) {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    return;
                }

            } catch (Exception e) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        filterChain.doFilter(request, response);
    }
}