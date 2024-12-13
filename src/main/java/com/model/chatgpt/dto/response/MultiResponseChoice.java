package com.model.chatgpt.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.model.chatgpt.dto.request.MultiChatMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Richa Pokhrel
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MultiResponseChoice {

    private MultiChatMessage message;

    @JsonProperty("finish_reason")
    private String finishReason;

    private Integer index;
}
