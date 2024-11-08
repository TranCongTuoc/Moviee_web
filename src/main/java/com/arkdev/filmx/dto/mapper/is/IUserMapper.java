package com.arkdev.filmx.dto.mapper.is;

import com.arkdev.filmx.dto.request.RegisterRequest;
import com.arkdev.filmx.dto.request.UserUpdateRequest;
import com.arkdev.filmx.dto.response.UserResponse;
import com.arkdev.filmx.model.User;

public interface IUserMapper {
    User toUser(RegisterRequest request);
    void updateUser(User user, UserUpdateRequest request);
    UserResponse toUserResponse(User user);
}
