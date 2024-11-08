package com.arkdev.filmx.controller;

import com.arkdev.filmx.dto.request.RegisterRequest;
import com.arkdev.filmx.dto.request.UserUpdateRequest;
import com.arkdev.filmx.dto.response.UserResponse;
import com.arkdev.filmx.service.is.IUserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {
    IUserService userService;

    @GetMapping("/")
    public ResponseEntity<?> getAllUsers(HttpServletResponse response) {
        List<UserResponse> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/register")
    public ResponseEntity<?> addUser(@RequestBody @Validated RegisterRequest request,
                                     HttpServletResponse response){
        userService.insertUser(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateUser(@RequestParam Long UserId, @RequestBody @Validated UserUpdateRequest request) {
        userService.updateUser(UserId, request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteUser(@RequestParam Long UserId) {
        userService.deleteUser(UserId);
        return ResponseEntity.ok().build();
    }
}
