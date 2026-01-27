package com.rishbootdev.bloomway.repository;

import com.rishbootdev.bloomway.entity.ChatEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatEventRepository extends JpaRepository<ChatEvent, Long> {
}

