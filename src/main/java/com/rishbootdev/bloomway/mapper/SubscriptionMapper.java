package com.rishbootdev.bloomway.mapper;


import com.rishbootdev.bloomway.dto.subscription.PlanResponse;
import com.rishbootdev.bloomway.dto.subscription.SubscriptionResponse;
import com.rishbootdev.bloomway.entity.Plan;
import com.rishbootdev.bloomway.entity.Subscription;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubscriptionMapper {

    SubscriptionResponse toSubscriptionResponse(Subscription subscription);

    PlanResponse toPlanResponse(Plan plan);
}
