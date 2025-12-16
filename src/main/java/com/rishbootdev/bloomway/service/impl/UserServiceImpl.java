package com.rishbootdev.bloomway.service.impl;

import com.rishbootdev.bloomway.dto.auth.UserProfileResponse;
import com.rishbootdev.bloomway.exceptions.ResourceNotFoundException;
import com.rishbootdev.bloomway.repository.UserRepository;
import com.rishbootdev.bloomway.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    @Override
    public UserProfileResponse getProfile(Long userId) {
        return null;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        return userRepository.findUserByNameIs(username).orElseThrow(()-> new ResourceNotFoundException("User ",username));
    }
}
