package com.arkdev.filmx.service.is;

import com.arkdev.filmx.model.User;

public interface ITokenService {
    String generateToken(User user);

    String validateToken(String token);
}
