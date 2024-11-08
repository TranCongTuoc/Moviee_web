package com.arkdev.filmx.service;

import com.arkdev.filmx.dto.response.UserResponse;
import com.arkdev.filmx.model.User;
import com.arkdev.filmx.service.is.IAuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthService implements IAuthService {
    AuthenticationManager authenticationManager;
    com.arkdev.filmx.service.is.IUserService IUserService;
    com.arkdev.filmx.service.is.ITokenService ITokenService;

    @Override
    public String accessAccount(String username, String password) {
        UserResponse user = IUserService.getUserByUsername(username);
        if (user != null) {
            var usernamePassword = new UsernamePasswordAuthenticationToken(username, password);
            var auth = authenticationManager.authenticate(usernamePassword);
            return ITokenService.generateToken((User) auth.getPrincipal());
        }
        return null;
    }
}
