package com.model.chatgpt.dto.request;

import lombok.*;

/**
 * @author Richa Pokhrel
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MultiChatMessage {

    private String role;
    private String content;
}
