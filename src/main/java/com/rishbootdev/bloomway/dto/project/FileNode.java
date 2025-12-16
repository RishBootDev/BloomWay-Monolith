package com.rishbootdev.bloomway.dto.project;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

public record FileNode(
        @NotBlank String path,
        Instant modifiedAt,
        @NotNull Long size,
        @NotBlank String type
) {
}
