package com.arkdev.filmx.dto.request;

import com.arkdev.filmx.util.Type;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Setter
@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegisterRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3567232019040985312L;

	@NotNull(message = "Full name must be not null")
    @NotBlank(message = "Full name must be not blank")
    String fullName;

    @NotNull(message = "Username must be not null")
    @NotBlank(message = "Username must be not blank")
    String username;

    @NotNull(message = "Email must be not null")
    @NotBlank(message = "Email must be not blank")
    @Email
    String email;

    @NotNull(message = "Password must be not null")
    @NotBlank(message = "Password must be not blank")
    String password;

    Type role;
}
