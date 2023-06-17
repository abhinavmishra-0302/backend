package com.hiatus.backend.services;

import com.hiatus.backend.model.UserData;
import com.hiatus.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateInfoService {

    private UserRepository userRepository;

    public UpdateInfoService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserData updateUser(Long id, UserData updatedUser) {
        UserData existingUser = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + id));

        existingUser.setFullName(updatedUser.getFullName());

        UserData savedUser = userRepository.save(existingUser);

        return savedUser;
    }

    public void deleteUser(Long id) {
        UserData existingUser = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + id));

        userRepository.delete(existingUser);
    }
}
