package com.rishbootdev.bloomway.dto.project;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

public record ProjectSummaryResponse(

        @NotNull Long id,
        @NotBlank String projectName,
        Instant createdAt,
        Instant updatedAt
) {
}
