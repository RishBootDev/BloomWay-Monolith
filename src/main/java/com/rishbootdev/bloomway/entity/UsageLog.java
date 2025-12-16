package com.rishbootdev.bloomway.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;


@Getter
@Setter
@Builder
public class UsageLog {

    private Long id;
    private User user;
    private Project project;

    private String action;

    private Integer tokensUsed;
    private Integer durationMs;

    private String metaData; // JSON of {model_used, prompt_used},

    private Instant createdAt;
}
