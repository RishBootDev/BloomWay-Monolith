package com.rishbootdev.bloomway.service;


import com.rishbootdev.bloomway.dto.subscription.PlanLimitsResponse;
import com.rishbootdev.bloomway.dto.subscription.UsageTodayResponse;

public interface UsageService {
     void recordTokenUsage(Long userId, int actualTokens);
     void checkDailyTokensUsage();
}
