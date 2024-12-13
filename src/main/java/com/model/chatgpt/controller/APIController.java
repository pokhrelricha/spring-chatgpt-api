package com.model.chatgpt.controller;

import com.model.chatgpt.dto.request.ChatRequest;
import com.model.chatgpt.dto.request.MultiChatRequest;
import com.model.chatgpt.dto.response.ChatResponse;
import com.model.chatgpt.service.ChatGPTMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Richa Pokhrel
 */
@RestController
@RequestMapping("/chat")
public class APIController {

    @Autowired
    private ChatGPTMessageService chatGPTMessageService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> chat(ChatRequest chatRequest) {
        ChatResponse chatResponse = chatGPTMessageService.sendChatRequest(chatRequest);

        if (chatResponse.isSuccess()) {
            return new ResponseEntity<>(chatResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(chatResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "multi", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> multiChat(MultiChatRequest chatRequest) {
        ChatResponse chatResponse = chatGPTMessageService.sendMultiChatRequest(chatRequest);

        if (chatResponse.isSuccess()) {
            return new ResponseEntity<>(chatResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(chatResponse, HttpStatus.BAD_REQUEST);
        }
    }

}
