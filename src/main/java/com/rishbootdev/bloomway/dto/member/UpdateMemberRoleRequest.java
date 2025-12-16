package com.rishbootdev.bloomway.dto.member;


import com.rishbootdev.bloomway.enums.ProjectRole;
import jakarta.validation.constraints.NotNull;

public record UpdateMemberRoleRequest(
        @NotNull ProjectRole role) {
}
