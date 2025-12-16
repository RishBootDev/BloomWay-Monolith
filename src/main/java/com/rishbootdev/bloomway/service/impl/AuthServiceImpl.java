package com.rishbootdev.bloomway.service.impl;


import com.rishbootdev.bloomway.dto.auth.AuthResponse;
import com.rishbootdev.bloomway.dto.auth.LoginRequest;
import com.rishbootdev.bloomway.dto.auth.SignupRequest;
import com.rishbootdev.bloomway.dto.auth.UserProfileResponse;
import com.rishbootdev.bloomway.entity.User;
import com.rishbootdev.bloomway.exceptions.BadRequestException;
import com.rishbootdev.bloomway.mapper.UserMapper;
import com.rishbootdev.bloomway.repository.UserRepository;
import com.rishbootdev.bloomway.service.AuthService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse signup(SignupRequest request) {
        userRepository.findUserByNameIs(request.name())
                .ifPresent(user-> {
                    throw new BadRequestException("User already exists with UserName"+request.name());
                });

        User user=userMapper.toEntity(request);
        user.setPasswordHash(passwordEncoder.encode(request.password()));
        user= userRepository.save(user);

        UserProfileResponse profileResponse=userMapper.toUserProfileResponse(user);

        return new AuthResponse("dummy",profileResponse);
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        return null;
    }
}
