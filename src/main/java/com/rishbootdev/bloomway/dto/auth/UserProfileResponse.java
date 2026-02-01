package com.rishbootdev.bloomway.dto.auth;


public record UserProfileResponse(
        Long id,
        String username,
        String name,
        String avatarUrl
) {
}
