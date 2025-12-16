package com.rishbootdev.bloomway.service;


import com.rishbootdev.bloomway.dto.subscription.CheckoutRequest;
import com.rishbootdev.bloomway.dto.subscription.CheckoutResponse;
import com.rishbootdev.bloomway.dto.subscription.PortalResponse;
import com.rishbootdev.bloomway.dto.subscription.SubscriptionResponse;

public interface SubscriptionService {
    SubscriptionResponse getCurrentSubscription(Long userId);

    CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request, Long userId);

    PortalResponse openCustomerPortal(Long userId);
}
