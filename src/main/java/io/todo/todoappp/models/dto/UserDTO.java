package io.todo.todoappp.models.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserDTO {

    @NotBlank(message = "Email is mandatory")
    private final String email;

    @NotBlank(message = "Password is mandatory")
    private final String password;
}
