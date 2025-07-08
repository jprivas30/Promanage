package com.promanage.user.service;

import com.promanage.user.dto.UserDto;
import java.util.List;

public interface UserService {

    List<UserDto> getAllUsers();
    UserDto getUserById(Long id);
    UserDto createUser(UserDto userDto);
    UserDto updateUser(Long id, UserDto userDto);
    void deleteUser(Long id);
}