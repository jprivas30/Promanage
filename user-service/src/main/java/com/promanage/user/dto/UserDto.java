package com.promanage.user.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class UserDto {
    private Long id;
    private String username;
    private String email;
}
