package com.model.chatgpt.controller;

import com.model.chatgpt.dto.request.ChatRequest;
import com.model.chatgpt.dto.request.MultiChatMessageList;
import com.model.chatgpt.dto.request.MultiChatRequest;
import com.model.chatgpt.dto.response.ChatResponse;
import com.model.chatgpt.service.ChatGPTMessageService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for handling chat requests to OpenAI's API.
 * <p>
 * This controller provides endpoints to handle both single and multi-chat requests
 * using the {@link ChatGPTMessageService}.
 * </p>
 *
 * @author Richa Pokhrel
 */
@Slf4j
@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatGPTMessageService chatGPTMessageService;

    /**
     * Handles a single chat request and returns the response from OpenAI.
     *
     * @param chatRequest The {@link ChatRequest} containing the prompt for OpenAI.
     *                    Must not be null and must contain a valid prompt.
     * @return A {@link ResponseEntity} containing the {@link ChatResponse} with success status and message content.
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> chat(@RequestBody @NotNull @Valid ChatRequest chatRequest) {
        log.info("Entering API Chat to send chat request...");
        ChatResponse chatResponse = chatGPTMessageService.sendChatRequest(chatRequest);

        if (chatResponse.isSuccess()) {
            return new ResponseEntity<>(chatResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(chatResponse, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Handles a multi-chat request and returns the response from OpenAI.
     *
     * @param multiChatMessageList The {@link MultiChatRequest} containing multiple prompts for OpenAI.
     *                    Must not be null and must contain valid prompts.
     * @return A {@link ResponseEntity} containing the {@link ChatResponse} with success status and the first message content.
     */
    @PostMapping(value = "multi", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> multiChat(@RequestBody @NotNull @Valid MultiChatMessageList multiChatMessageList) {
        log.info("Entering API Multi-chat to send chat request...");

        ChatResponse chatResponse = chatGPTMessageService.sendMultiChatRequest(multiChatMessageList);

        if (chatResponse.isSuccess()) {
            return new ResponseEntity<>(chatResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(chatResponse, HttpStatus.BAD_REQUEST);
        }
    }

}
