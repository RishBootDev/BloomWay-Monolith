package com.rishbootdev.bloomway.dto.project;


import com.rishbootdev.bloomway.dto.auth.UserProfileResponse;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

public record ProjectResponse(
        @NotNull Long id,
        @NotBlank String name,
        Instant createdAt,
        Instant updatedAt,
        @NotNull UserProfileResponse owner
) {
}
