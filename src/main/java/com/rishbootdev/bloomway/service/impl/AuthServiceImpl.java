package com.rishbootdev.bloomway.service.impl;

import com.rishbootdev.bloomway.dto.auth.AuthResponse;
import com.rishbootdev.bloomway.dto.auth.LoginRequest;
import com.rishbootdev.bloomway.dto.auth.SignupRequest;
import com.rishbootdev.bloomway.dto.auth.UserProfileResponse;
import com.rishbootdev.bloomway.entity.User;
import com.rishbootdev.bloomway.exceptions.BadRequestException;
import com.rishbootdev.bloomway.mapper.UserMapper;
import com.rishbootdev.bloomway.repository.UserRepository;
import com.rishbootdev.bloomway.security.AuthUtil;
import com.rishbootdev.bloomway.service.AuthService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Slf4j
public class AuthServiceImpl implements AuthService {

    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;
    AuthUtil authUtil;
    AuthenticationManager authenticationManager;

    @Override
    public AuthResponse signup(SignupRequest request) {
        userRepository.findUserByNameIs(request.username()).ifPresent(user -> {
            throw new BadRequestException("User already exists with username: "+request.username());
        });

        User user = userMapper.toEntity(request);
        user.setPasswordHash(passwordEncoder.encode(request.password()));
        user = userRepository.save(user);

        String token = authUtil.generateAccessToken(user);
        return new AuthResponse(token, userMapper.toUserProfileResponse(user));
    }

    @Override
    public AuthResponse login(LoginRequest request) {

        log.info("The user wanted to login is :{}",request.username());
        log.info("The request is :{}",request);
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password())
        );

        User user = (User) authentication.getPrincipal();

        log.info("the user wanted to login is :{}",user);

        String token = authUtil.generateAccessToken(user);

        log.info("the user wanted to login is :{}", user);

        return new AuthResponse(token, userMapper.toUserProfileResponse(user));
    }
}

