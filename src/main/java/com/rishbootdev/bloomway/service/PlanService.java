package com.rishbootdev.bloomway.service;


import com.rishbootdev.bloomway.dto.subscription.PlanResponse;

import java.util.List;

public interface PlanService {
     List<PlanResponse> getAllActivePlans();
}
