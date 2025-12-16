package com.rishbootdev.bloomway.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserProfileResponse(
        Long id,
        @Email
        @NotBlank
        String email,
        String name,
        String avatarUrl
) {
}
