package com.model.chatgpt.service;

import com.model.chatgpt.dto.request.ChatRequest;
import com.model.chatgpt.dto.request.MultiChatRequest;
import com.model.chatgpt.dto.response.ChatResponse;

import java.util.List;

/**
 * @author Richa Pokhrel
 */
public interface ChatGPTImageService {

    String sendImageRequest(ChatRequest chatRequest);

    List<String> sendMultiImageRequest(ChatRequest chatRequest);
}
