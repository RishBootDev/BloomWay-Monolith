package com.rishbootdev.bloomway.dto.chat;


import com.rishbootdev.bloomway.entity.ChatEvent;
import com.rishbootdev.bloomway.entity.ChatSession;
import com.rishbootdev.bloomway.enums.MessageRole;

import java.time.Instant;
import java.util.List;

public record ChatResponse(
        Long id,
        ChatSession chatSession,
        MessageRole role,
        List<ChatEvent> events,
        String content,
        Integer tokensUsed,
        Instant createdAt

) {
}

