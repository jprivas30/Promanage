package com.promanage.auth.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter


public class AuthRequest {
    private String username;
    private String password;
    private String email;
}