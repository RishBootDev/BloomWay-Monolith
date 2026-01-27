package com.rishbootdev.bloomway.service;

import com.rishbootdev.bloomway.dto.chat.ChatResponse;

import java.util.List;

public interface ChatService {

    List<ChatResponse> getProjectChatHistory(Long projectId);
}