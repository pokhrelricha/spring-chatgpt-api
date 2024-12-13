package com.model.chatgpt.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Richa Pokhrel
 */
@Setter
@Getter
public class ChatRequest {
    @NotBlank
    private String prompt;
}
