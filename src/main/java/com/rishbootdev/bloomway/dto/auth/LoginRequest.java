package com.rishbootdev.bloomway.dto.auth;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginRequest(
        @Email
        String email,
        @NotBlank @Size(min = 6,max=50)
        String password
) {
}
