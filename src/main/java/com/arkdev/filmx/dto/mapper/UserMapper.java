package com.arkdev.filmx.dto.mapper;

import com.arkdev.filmx.dto.mapper.is.IUserMapper;
import com.arkdev.filmx.dto.request.RegisterRequest;
import com.arkdev.filmx.dto.request.UserUpdateRequest;
import com.arkdev.filmx.dto.response.UserResponse;
import com.arkdev.filmx.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements IUserMapper {
    @Override
    public User toUser(RegisterRequest request) {
        if (request == null) {
            return null;
        } else {
            User.UserBuilder user = User.builder();
            user.fullName(request.getFullName());
            user.username(request.getUsername());
            user.email(request.getEmail());
            user.password(request.getPassword());
            user.role(request.getRole());
            return user.build();
        }
    }

    @Override
    public void updateUser(User user, UserUpdateRequest request) {
        if (request != null) {
            user.setFullName(request.getFullName());
            user.setUsername(request.getUsername());
            user.setEmail(request.getEmail());
        }
    }

    @Override
    public UserResponse toUserResponse(User user) {
        if (user == null) {
            return null;
        } else {
            return new UserResponse(
                    user.getFullName(),
                    user.getUsername(),
                    user.getEmail(),
                    user.getAvatarUrl(),
                    user.getRole()
            );
        }
    }
}
