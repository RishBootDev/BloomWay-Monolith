package com.rishbootdev.bloomway.dto.member;


import com.rishbootdev.bloomway.enums.ProjectRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InviteMemberRequest(
        @Email @NotBlank String username,
        @Email String email,
        @NotNull ProjectRole role
) {
}
