package com.rishbootdev.bloomway.entity;

import com.rishbootdev.bloomway.enums.MessageRole;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;



@Getter
@Setter
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "chat_session_id")
    private ChatSession chatSession;

    private String content;

    private MessageRole role;

    private String toolCalls; // JSON Array of Tools Called

    private Integer tokensUsed;

    private Instant createdAt;
}
