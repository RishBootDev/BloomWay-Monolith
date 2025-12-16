package com.rishbootdev.bloomway.service.impl;


import com.rishbootdev.bloomway.dto.subscription.PlanResponse;
import com.rishbootdev.bloomway.service.PlanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {
    @Override
    public List<PlanResponse> getAllActivePlans() {
        return List.of();
    }
}
