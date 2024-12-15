package com.model.chatgpt.service.impl;

import com.model.chatgpt.config.properties.ChatProperties;
import com.model.chatgpt.connector.OpenAIConnector;
import com.model.chatgpt.constant.ResponseCodeConstant;
import com.model.chatgpt.dto.request.ChatGPTRequest;
import com.model.chatgpt.dto.request.ChatRequest;
import com.model.chatgpt.dto.request.MultiChatMessageList;
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
 * Implementation of the {@link ChatGPTMessageService} interface to handle communication with OpenAI's API.
 * <p>
 * This service handles requests to and responses from the OpenAI API, using the {@link OpenAIConnector}
 * for API integration and {@link RestTemplate} for HTTP communication.
 * </p>
 *
 * @author Richa Pokhrel
 */
@Slf4j
@Service
public class ChatGPTMessageServiceImpl implements ChatGPTMessageService {

    @Autowired
    private ChatProperties chatProperties;

    @Autowired
    private OpenAIConnector openAIConnector;

    @Override
    public ChatResponse sendChatRequest(ChatRequest chatRequest) {
        ChatGPTRequest request = new ChatGPTRequest(chatProperties.getModel(), chatRequest.getPrompt());

        ChatGPTResponse response = openAIConnector.response(
                openAIConnector.buildHttpEntity(request), ChatGPTResponse.class, chatProperties.getUrl());

        if (response == null || response.getChoices() == null || response.getChoices().isEmpty()) {
            return new ChatResponse(false, ResponseCodeConstant.SERVER_ERROR, "No response");
        }
        return new ChatResponse(true, ResponseCodeConstant.SUCCESS,
                response.getChoices().getFirst().getMessage().getContent());

    }

    @Override
    public ChatResponse sendMultiChatRequest(MultiChatMessageList multiChatMessageList) {

        MultiChatRequest multiChatRequest = new MultiChatRequest(chatProperties.getModel(),
                multiChatMessageList.getMultiChatMessageList(), chatProperties.getMaxTokens(),
                chatProperties.getTemperature(), chatProperties.getTopP());

        MultiChatResponse multiChatResponse = openAIConnector.response(
                openAIConnector.buildHttpEntity(multiChatRequest), MultiChatResponse.class, chatProperties.getUrl());

        String message = multiChatResponse.getChoices().getFirst().getMessage().getContent();
        return new ChatResponse(true, ResponseCodeConstant.SUCCESS, message);

    }
}
