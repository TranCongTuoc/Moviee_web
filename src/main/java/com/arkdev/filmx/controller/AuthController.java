package com.arkdev.filmx.controller;

import com.arkdev.filmx.dto.request.LoginRequest;
import com.arkdev.filmx.dto.response.TokenResponse;
import com.arkdev.filmx.service.is.IAuthService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Validated
public class AuthController {
    IAuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Validated LoginRequest request,
                                   HttpServletResponse response) {
        String token = authService.accessAccount(request.username(), request.password());
        Cookie cookie = new Cookie("access_token", token);
        cookie.setHttpOnly(true);
        cookie.setSecure(false);
        cookie.setPath("/");
        response.addCookie(cookie);
        return ResponseEntity.ok(new TokenResponse(token));
    }
}
