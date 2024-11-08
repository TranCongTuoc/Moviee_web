package com.arkdev.filmx.service.is;

import com.arkdev.filmx.dto.request.RegisterRequest;
import com.arkdev.filmx.dto.request.UserUpdateRequest;
import com.arkdev.filmx.dto.response.UserResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService {
    UserDetailsService userDetailsService();

    Long insertUser(RegisterRequest request);

    void updateUser(Long userId, UserUpdateRequest request);

    void deleteUser(Long userId);

    List<UserResponse> getAllUsers();

    UserResponse getUserById(Long userId);

    UserResponse getUserByUsername(String username);
}
