package com.rishbootdev.bloomway.dto.project;

import jakarta.validation.constraints.NotBlank;

public record FileNode(
        String path
) {

    @Override
    public String toString() {
        return path;
    }
}
