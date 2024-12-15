package com.model.chatgpt.controller;

import com.model.chatgpt.dto.request.ChatRequest;
import com.model.chatgpt.dto.response.ChatResponse;
import com.model.chatgpt.service.ChatGPTImageService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller for handling image generation requests.
 * <p>
 * Provides endpoints to generate single or multiple images based on
 * requests sent to the ChatGPTMessageService.
 *
 * @author Richa Pokhrel
 */
@Slf4j
@RestController
@RequestMapping("/generate")
public class ImageController {

    @Autowired
    private ChatGPTImageService chatGPTImageService;

    /**
     * Handles the request to generate a single image.
     * <p>
     * This endpoint accepts a JSON payload representing the chat request details,
     * sends it to the ChatGPTMessageService, and returns the response.
     *
     * @param chatRequest The request containing details for generating a single image.
     *                    Must not be null and must pass validation constraints.
     * @return A {@link ResponseEntity} containing a {@link ChatResponse} object
     * with details of the generated image and an appropriate HTTP status code.
     */
    @PostMapping(value = "image", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> chat(@RequestBody @NotNull @Valid ChatRequest chatRequest) {
        log.info("Entering API Chat to send chat request...");
        String imageResponse = chatGPTImageService.sendImageRequest(chatRequest);

        return new ResponseEntity<>(imageResponse, HttpStatus.OK);
    }

    /**
     * Handles the request to generate multiple images.
     * <p>
     * This endpoint accepts a JSON payload representing the chat request details
     * for generating multiple images, sends it to the ChatGPTMessageService,
     * and returns the response.
     *
     * @param chatRequest The request containing details for generating multiple images.
     *                    Must not be null and must pass validation constraints.
     * @return A {@link ResponseEntity} containing a {@link ChatResponse} object
     * with details of the generated images and an appropriate HTTP status code.
     */
    @PostMapping(value = "images", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> multiChat(@RequestBody @NotNull @Valid ChatRequest chatRequest) {
        log.info("Entering API Multi-chat to send chat request...");

        List<String> stringList = chatGPTImageService.sendMultiImageRequest(chatRequest);

        return new ResponseEntity<>(stringList, HttpStatus.OK);
    }
}

