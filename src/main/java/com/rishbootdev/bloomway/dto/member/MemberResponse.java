package com.rishbootdev.bloomway.dto.member;

import com.rishbootdev.bloomway.enums.ProjectRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

public record MemberResponse(
        @NotNull Long userId,
        @Email @NotBlank String email,
        @NotBlank String name,
        @NotNull ProjectRole projectRole,
        Instant invitedAt
) {
}
