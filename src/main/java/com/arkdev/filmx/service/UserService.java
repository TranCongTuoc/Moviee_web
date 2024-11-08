package com.arkdev.filmx.service;

import com.arkdev.filmx.dto.mapper.is.IUserMapper;
import com.arkdev.filmx.dto.request.RegisterRequest;
import com.arkdev.filmx.dto.request.UserUpdateRequest;
import com.arkdev.filmx.dto.response.UserResponse;
import com.arkdev.filmx.model.User;
import com.arkdev.filmx.repository.UserRepository;
import com.arkdev.filmx.service.is.IUserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserService implements IUserService {
    UserRepository userRepository;
    IUserMapper userMapper;

    @Override
    public UserDetailsService userDetailsService() {
        return username -> userRepository.findByUsername(username).
                orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public Long insertUser(RegisterRequest request) {
        User user = userMapper.toUser(request);
        user.setPassword(new BCryptPasswordEncoder().encode(request.getUsername()));
        userRepository.save(user);
        log.info("Inserted user: {}", user);
        return user.getUserId();
    }

    @Override
    public void updateUser(Long userId, UserUpdateRequest request) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new RuntimeException("User not found"));
        userMapper.updateUser(user, request);
        userRepository.save(user);
        log.info("Updated user: {}", user);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
        log.info("Deleted user: {}", userId);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toUserResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse getUserById(Long userId) {
        return userMapper.toUserResponse(userRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException("User not found")));
    }

    @Override
    public UserResponse getUserByUsername(String username) {
        return userMapper.toUserResponse(userRepository.findByUsername(username)
                .orElseThrow(()-> new RuntimeException("User not found")));
    }
}
