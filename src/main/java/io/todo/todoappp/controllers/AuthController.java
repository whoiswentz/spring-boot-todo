package io.todo.todoappp.controllers;

import io.todo.todoappp.models.User;
import io.todo.todoappp.models.dto.UserDTO;
import io.todo.todoappp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.management.Query;
import javax.validation.Valid;
import java.util.Queue;

@RestController
public class AuthController {

    private final UserRepository userRepository;

    @Autowired
    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("signup")
    public UserDTO createUser(@Valid @RequestBody UserDTO newUserParams) {
        var user = User.builder()
                .email(newUserParams.getEmail())
                .password(newUserParams.getPassword())
                .build();

        var result = userRepository.insert(user);
        return new UserDTO(result.getEmail(), result.getPassword());
    }

    @PostMapping("signin")
    public UserDTO login(@Valid @RequestBody UserDTO loginParams) {
        final var user = userRepository.findByEmail(loginParams.getEmail());
        return new UserDTO(user.getEmail(), user.getPassword());
    }
}
