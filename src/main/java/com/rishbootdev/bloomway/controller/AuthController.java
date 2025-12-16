package com.rishbootdev.bloomway.controller;


import com.rishbootdev.bloomway.dto.auth.AuthResponse;
import com.rishbootdev.bloomway.dto.auth.LoginRequest;
import com.rishbootdev.bloomway.dto.auth.SignupRequest;
import com.rishbootdev.bloomway.dto.auth.UserProfileResponse;
import com.rishbootdev.bloomway.security.AuthUtil;
import com.rishbootdev.bloomway.service.AuthService;
import com.rishbootdev.bloomway.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;
    private UserService userService;


    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signup(@RequestBody SignupRequest request) {
        return ResponseEntity.ok(authService.signup(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> getProfile() {
        Long userId = 1L;
        return ResponseEntity.ok(userService.getProfile(userId));
    }

}
