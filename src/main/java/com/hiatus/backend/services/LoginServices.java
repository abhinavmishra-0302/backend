package com.hiatus.backend.services;

import com.hiatus.backend.model.UserData;
import com.hiatus.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginServices {
    private UserRepository userRepository;

    public LoginServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserData findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public boolean validateCredentials(String username, String password) {
        UserData user = userRepository.findByUsername(username);
        return user != null && user.getPassword().equals(password);
    }
}
