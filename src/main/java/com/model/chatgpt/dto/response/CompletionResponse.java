package com.model.chatgpt.dto.response;

import lombok.Data;

import java.util.List;

/**
 * @author Richa Pokhrel
 */
@Data
public class CompletionResponse {
    private List<Choice> choices;

    @Data
    public static class Choice {
        private String text; // Generated text response
        private Integer index;
        private String finish_reason;
    }
}
