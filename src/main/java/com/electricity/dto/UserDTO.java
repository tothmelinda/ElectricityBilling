package com.electricity.dto;

import com.electricity.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    @NotEmpty(message = "Password cannot be empty")
    private String password;

    @Pattern(regexp = "^\\+40\\d{9}$", message = "Invalid phone number format")
    private String phoneNumber;

    private String image;

    @Enumerated(EnumType.STRING)
    private Role role;
}
