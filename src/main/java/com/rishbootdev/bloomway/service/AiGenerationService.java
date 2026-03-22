package com.rishbootdev.bloomway.service;

import com.rishbootdev.bloomway.dto.chat.StreamResponse;
import reactor.core.publisher.Flux;

public interface AiGenerationService {

    Flux<StreamResponse> streamResponse(String message, Long projectId);

}
