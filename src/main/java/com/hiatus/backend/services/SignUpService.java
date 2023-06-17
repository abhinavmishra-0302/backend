package com.hiatus.backend.services;

import com.hiatus.backend.model.SignUpRequest;
import com.hiatus.backend.model.SignUpResponse;
import com.hiatus.backend.model.UserData;
import com.hiatus.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {

    private UserRepository userRepository;

    public SignUpService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public SignUpResponse signUpUser(SignUpRequest request) {
        String fullName = request.getFullName();
        String username = request.getUsername();
        String password = request.getPassword();

        if (userRepository.findByUsername(username) != null) {
            return new SignUpResponse(false, "Username already exists");
        }

        UserData user = new UserData();
        user.setFullName(fullName);
        user.setUsername(username);
        user.setPassword(password);

        userRepository.save(user);

        return new SignUpResponse(true, "Sign up successful");
    }
}
