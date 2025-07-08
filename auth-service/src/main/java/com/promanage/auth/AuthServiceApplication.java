package com.promanage.auth;

import com.promanage.auth.model.User;
import com.promanage.auth.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class AuthServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (!userRepository.existsByEmail("admin@promanage.com")) {
                User user = new User();
                user.setEmail("admin@promanage.com");
                user.setPassword(passwordEncoder.encode("admin123"));
                user.setRoles("ROLE_ADMIN");
                userRepository.save(user);
            }
        };
    }
}
