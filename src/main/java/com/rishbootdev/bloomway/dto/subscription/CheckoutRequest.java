package com.rishbootdev.bloomway.dto.subscription;

import jakarta.validation.constraints.NotNull;

public record CheckoutRequest(
        @NotNull Long planId
) {
}
