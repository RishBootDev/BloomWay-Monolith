package com.rishbootdev.bloomway.service.impl;

import com.rishbootdev.bloomway.dto.subscription.CheckoutRequest;
import com.rishbootdev.bloomway.dto.subscription.CheckoutResponse;
import com.rishbootdev.bloomway.dto.subscription.PortalResponse;
import com.rishbootdev.bloomway.dto.subscription.SubscriptionResponse;
import com.rishbootdev.bloomway.service.SubscriptionService;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Override
    public SubscriptionResponse getCurrentSubscription(Long userId) {
        return null;
    }

    @Override
    public CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request, Long userId) {
        return null;
    }

    @Override
    public PortalResponse openCustomerPortal(Long userId) {
        return null;
    }
}
