package com.arkdev.filmx.dto.response;

import com.arkdev.filmx.util.Type;

public record UserResponse (
        String fullName,
        String username,
        String email,
        String avatarUrl,
        Type role
){
}
