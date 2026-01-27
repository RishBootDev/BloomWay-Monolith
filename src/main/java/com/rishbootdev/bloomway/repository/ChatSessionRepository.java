package com.rishbootdev.bloomway.repository;

import com.rishbootdev.bloomway.entity.ChatSession;
import com.rishbootdev.bloomway.entity.ChatSessionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatSessionRepository extends JpaRepository<ChatSession, ChatSessionId> {
}
