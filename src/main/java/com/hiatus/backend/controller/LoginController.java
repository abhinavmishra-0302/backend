package com.hiatus.backend.controller;

import com.hiatus.backend.model.LoginRequest;
import com.hiatus.backend.model.LoginResponse;
import com.hiatus.backend.services.LoginServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private final LoginServices userService;

    public LoginController(LoginServices userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        String username = request.getUsername();
        String password = request.getPassword();

        boolean isValidCredentials = userService.validateCredentials(username, password);
        if (isValidCredentials) {
            return new LoginResponse(true, "Login successful");
        } else {
            return new LoginResponse(false, "Invalid username or password");
        }
    }
}
