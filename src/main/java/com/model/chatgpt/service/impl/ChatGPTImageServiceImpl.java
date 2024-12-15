package com.model.chatgpt.service.impl;

import com.model.chatgpt.config.properties.ImageProperties;
import com.model.chatgpt.connector.OpenAIConnector;
import com.model.chatgpt.dto.ImageFormat;
import com.model.chatgpt.dto.request.ChatRequest;
import com.model.chatgpt.dto.request.ImageRequest;
import com.model.chatgpt.dto.request.ImageSize;
import com.model.chatgpt.dto.response.ImageResponse;
import com.model.chatgpt.service.ChatGPTImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Richa Pokhrel
 */
@Slf4j
@Service
public class ChatGPTImageServiceImpl implements ChatGPTImageService {

    @Autowired
    private OpenAIConnector openAIConnector;

    @Autowired
    private ImageProperties imageProperties;

    @Override
    public String sendImageRequest(ChatRequest chatRequest) {

        ImageRequest imageRequest = new ImageRequest(chatRequest.getPrompt());
        ImageResponse imageResponse = openAIConnector.response(openAIConnector.buildHttpEntity(imageRequest), ImageResponse.class, imageProperties.getUrl());

        return imageResponse.getData().getFirst().getUrl();
    }

    @Override
    public List<String> sendMultiImageRequest(ChatRequest chatRequest) {
        ImageRequest imageRequest = new ImageRequest(chatRequest.getPrompt(), imageProperties.getNumber(),
                ImageSize.SMALL.getSize(), ImageFormat.URL.getFormat(), null);

        ImageResponse imageResponse = openAIConnector.response(openAIConnector.buildHttpEntity(imageRequest), ImageResponse.class, imageProperties.getUrl());

        List<String> list = new ArrayList<>();
        imageResponse.getData().forEach(imageData -> {
            if (ImageFormat.URL.equals(ImageFormat.URL)) {
                list.add(imageData.getUrl());
            } else {
                list.add(imageData.getB64Json());
            }
        });
        return list;

    }

}
