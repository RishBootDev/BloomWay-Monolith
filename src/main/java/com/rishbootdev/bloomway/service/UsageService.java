package com.rishbootdev.bloomway.service;


import com.rishbootdev.bloomway.dto.subscription.PlanLimitsResponse;
import com.rishbootdev.bloomway.dto.subscription.UsageTodayResponse;

public interface UsageService {
     UsageTodayResponse getTodayUsageOfUser(Long userId);

     PlanLimitsResponse getCurrentSubscriptionLimitsOfUser(Long userId);
}
