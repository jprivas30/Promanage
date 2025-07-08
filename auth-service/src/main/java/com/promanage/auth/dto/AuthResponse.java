package com.promanage.auth.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AuthResponse {
    private String token;
}