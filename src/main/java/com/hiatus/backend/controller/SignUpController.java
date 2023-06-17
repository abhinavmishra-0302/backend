package com.hiatus.backend.controller;

import com.hiatus.backend.model.SignUpRequest;
import com.hiatus.backend.model.SignUpResponse;
import com.hiatus.backend.services.SignUpService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignUpController {

    private SignUpService signUpService;

    public SignUpController(SignUpService signUpService) {
        this.signUpService = signUpService;
    }

    @PostMapping(value="/signup")
    public SignUpResponse signUp(@RequestBody SignUpRequest request) {
        return signUpService.signUpUser(request);
    }
}
