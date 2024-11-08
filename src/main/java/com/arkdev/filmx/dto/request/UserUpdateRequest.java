package com.arkdev.filmx.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateRequest implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1197623737913535335L;

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
}
