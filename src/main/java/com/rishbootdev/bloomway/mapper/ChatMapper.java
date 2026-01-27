package com.rishbootdev.bloomway.mapper;


import com.rishbootdev.bloomway.dto.chat.ChatResponse;
import com.rishbootdev.bloomway.entity.ChatMessage;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChatMapper {

    List<ChatResponse> fromListOfChatMessage(List<ChatMessage> chatMessageList);
}

