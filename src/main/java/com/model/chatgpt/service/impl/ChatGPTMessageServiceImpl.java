package com.model.chatgpt.service.impl;

import com.model.chatgpt.connector.OpenAIConnector;
import com.model.chatgpt.constant.ResponseCodeConstant;
import com.model.chatgpt.dto.request.ChatGPTRequest;
import com.model.chatgpt.dto.request.ChatRequest;
import com.model.chatgpt.dto.request.MultiChatRequest;
import com.model.chatgpt.dto.response.ChatGPTResponse;
import com.model.chatgpt.dto.response.ChatResponse;
import com.model.chatgpt.dto.response.MultiChatResponse;
import com.model.chatgpt.service.ChatGPTMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Richa Pokhrel
 */
@Slf4j
@Service
public class ChatGPTMessageServiceImpl implements ChatGPTMessageService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String apiUrl;

    @Autowired
    private OpenAIConnector openAIConnector;

    @Override
    public ChatResponse sendChatRequest(ChatRequest chatRequest) {
        ChatGPTRequest request = new ChatGPTRequest(model, chatRequest.getPrompt());

        ChatGPTResponse response = openAIConnector.getResponse(openAIConnector.buildHttpEntity(request), ChatGPTResponse.class, apiUrl);

        if (response == null || response.getChoices() == null || response.getChoices().isEmpty()) {
            return new ChatResponse(false, ResponseCodeConstant.SERVER_ERROR, "No response");
        }
        return new ChatResponse(true, ResponseCodeConstant.SUCCESS, response.getChoices().get(0).getMessage().getContent());

    }

    @Override
    public ChatResponse sendMultiChatRequest(MultiChatRequest multiChatRequest) {
        MultiChatResponse multiChatResponse = openAIConnector.getResponse(openAIConnector.buildHttpEntity(multiChatRequest), MultiChatResponse.class, apiUrl);
        try {
            String message = multiChatResponse.getChoices().get(0).getMessage().getContent();
            return new ChatResponse(true, ResponseCodeConstant.SUCCESS, message);
        } catch (Exception e) {
            log.error("parse chatgpt message error", e);
            return new ChatResponse(false, ResponseCodeConstant.SERVER_ERROR, "No response");
        }

    }
}
