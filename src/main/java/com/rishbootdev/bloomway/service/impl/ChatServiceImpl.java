package com.rishbootdev.bloomway.service.impl;


import com.rishbootdev.bloomway.dto.chat.ChatResponse;
import com.rishbootdev.bloomway.entity.ChatMessage;
import com.rishbootdev.bloomway.entity.ChatSession;
import com.rishbootdev.bloomway.entity.ChatSessionId;
import com.rishbootdev.bloomway.mapper.ChatMapper;
import com.rishbootdev.bloomway.repository.ChatMessageRepository;
import com.rishbootdev.bloomway.repository.ChatSessionRepository;
import com.rishbootdev.bloomway.security.AuthUtil;
import com.rishbootdev.bloomway.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChatServiceImpl implements ChatService {

    private final ChatMessageRepository chatMessageRepository;
    private final ChatSessionRepository chatSessionRepository;
    private final AuthUtil authUtil;
    private final ChatMapper chatMapper;

    @Override
    public List<ChatResponse> getProjectChatHistory(Long projectId) {
        Long userId = authUtil.getCurrentUserId();

        ChatSession chatSession = chatSessionRepository.getReferenceById(
                new ChatSessionId(projectId, userId)
        );

        List<ChatMessage> chatMessageList = chatMessageRepository.findByChatSession(chatSession);

        return chatMapper.fromListOfChatMessage(chatMessageList);
    }
}
