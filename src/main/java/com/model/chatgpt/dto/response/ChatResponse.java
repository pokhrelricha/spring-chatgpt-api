package com.model.chatgpt.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Richa Pokhrel
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatResponse {

    private boolean success;
    private Integer responseCode;
    private String message;
}
