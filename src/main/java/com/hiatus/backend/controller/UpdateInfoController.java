package com.hiatus.backend.controller;

import com.hiatus.backend.model.UserData;
import com.hiatus.backend.services.UpdateInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UpdateInfoController {

    private UpdateInfoService userService;

    public UpdateInfoController(UpdateInfoService userService) {
        this.userService = userService;
    }

    @PutMapping("/users/{id}")
    public UserData updateUser(@PathVariable Long id, @RequestBody UserData updatedUser) {
        return userService.updateUser(id, updatedUser);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}
