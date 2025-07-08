package com.promanage.user.service.impl;

import com.promanage.user.dto.UserDto;
import com.promanage.user.model.User;
import com.promanage.user.repository.UserRepository;
import com.promanage.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    // Obtener todos los usuarios
    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(user -> mapToDto(user)).collect(Collectors.toList());
    }

    // Obtener usuario por ID
    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
        return mapToDto(user);
    }

    // Crear nuevo usuario
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        User saved = userRepository.save(user);
        return mapToDto(saved);
    }

    // Actualizar usuario existente
    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));

        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        User updated = userRepository.save(user);
        return mapToDto(updated);
    }

    // Eliminar usuario
    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("Usuario no encontrado con ID: " + id);
        }
        userRepository.deleteById(id);
    }

    // Método privado para mapear entidad -> DTO
    private UserDto mapToDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        return dto;
    }

}