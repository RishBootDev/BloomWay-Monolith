package com.rishbootdev.bloomway.controller;


import com.rishbootdev.bloomway.dto.auth.AuthResponse;
import com.rishbootdev.bloomway.dto.auth.LoginRequest;
import com.rishbootdev.bloomway.dto.auth.SignupRequest;
import com.rishbootdev.bloomway.dto.auth.UserProfileResponse;

import com.rishbootdev.bloomway.service.AuthService;
import com.rishbootdev.bloomway.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    private final AuthService authService;
    private final UserService userService;


    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signup(@RequestBody SignupRequest request) {

        log.info("The sign up request is :{} {}",request.username(),request.email());
        return ResponseEntity.ok(authService.signup(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {

        log.info("the user if trying to login");

        AuthResponse resp = authService.login(request);

        log.info("the user is :{}",resp.user().name());
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> getProfile() {
        Long userId = 1L;
        return ResponseEntity.ok(userService.getProfile(userId));
    }

}
