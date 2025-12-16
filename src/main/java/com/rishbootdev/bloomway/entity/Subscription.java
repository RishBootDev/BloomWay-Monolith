package com.rishbootdev.bloomway.entity;

import com.rishbootdev.bloomway.enums.SubscriptionStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class Subscription {

    private Long id;

    private User user;
    private Plan plan;

    private SubscriptionStatus status;

    private String stripeCustomerId;
    private String stripeSubscriptionId;

    private Instant currentPeriodStart;
    private Instant currentPeriodEnd;
    private Boolean cancelAtPeriodEnd = false;

    private Instant createdAt;
    private Instant updatedAt;
}
