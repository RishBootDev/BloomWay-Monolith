package com.rishbootdev.bloomway.service.impl;


import com.rishbootdev.bloomway.dto.subscription.PlanLimitsResponse;
import com.rishbootdev.bloomway.dto.subscription.UsageTodayResponse;
import com.rishbootdev.bloomway.service.UsageService;
import org.springframework.stereotype.Service;

@Service
public class UsageServiceImpl implements UsageService {

    @Override
    public UsageTodayResponse getTodayUsageOfUser(Long userId) {
        return null;
    }

    @Override
    public PlanLimitsResponse getCurrentSubscriptionLimitsOfUser(Long userId) {
        return null;
    }
}
