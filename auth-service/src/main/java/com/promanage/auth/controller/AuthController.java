package com.promanage.auth.controller;

import com.promanage.auth.dto.AuthRequest;
import com.promanage.auth.dto.AuthResponse;
import com.promanage.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.promanage.auth.util.JwtUtil;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/validate")
    public ResponseEntity<?> validateToken(@RequestHeader("Authorization") String token) {
        boolean isValid = jwtUtil.validateToken(token.substring(7)); // sin "Bearer "
        return isValid ? ResponseEntity.ok().build() : ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
