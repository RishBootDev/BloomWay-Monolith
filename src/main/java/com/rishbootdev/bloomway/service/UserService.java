package com.rishbootdev.bloomway.service;


import com.rishbootdev.bloomway.dto.auth.UserProfileResponse;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {
    UserProfileResponse getProfile(Long userId);

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
