package com.model.chatgpt.service;

import com.model.chatgpt.dto.request.ChatRequest;
import com.model.chatgpt.dto.request.MultiChatMessageList;
import com.model.chatgpt.dto.response.ChatResponse;

/**
 * @author Richa Pokhrel
 */
public interface ChatGPTMessageService {

    ChatResponse sendChatRequest(ChatRequest chatRequest);

    ChatResponse sendMultiChatRequest(MultiChatMessageList multiChatRequest);
}
