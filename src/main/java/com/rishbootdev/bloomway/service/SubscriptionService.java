package com.rishbootdev.bloomway.service;


import com.rishbootdev.bloomway.dto.subscription.CheckoutRequest;
import com.rishbootdev.bloomway.dto.subscription.CheckoutResponse;
import com.rishbootdev.bloomway.dto.subscription.PortalResponse;
import com.rishbootdev.bloomway.dto.subscription.SubscriptionResponse;
import com.rishbootdev.bloomway.enums.SubscriptionStatus;

import java.time.Instant;

public interface SubscriptionService {
    SubscriptionResponse getCurrentSubscription();

    void activateSubscription(Long userId, Long planId, String subscriptionId, String customerId);

    void updateSubscription(String gatewaySubscriptionId, SubscriptionStatus status, Instant periodStart, Instant periodEnd, Boolean cancelAtPeriodEnd, Long planId);

    void cancelSubscription(String gatewaySubscriptionId);

    void renewSubscriptionPeriod(String subId, Instant periodStart, Instant periodEnd);

    void markSubscriptionPastDue(String subId);

    boolean canCreateNewProject();
}
