package com.model.chatgpt.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;
import java.util.Map;

/**
 * @author Richa Pokhrel
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MultiChatRequest {

    private String model;

    private List<MultiChatMessage> messages;

    @JsonProperty("max_tokens")
    private Integer maxTokens;

    private Double temperature;

    @JsonProperty("top_p")
    private Double topP;

    private Integer n;

    private Boolean stream;

    private String stop;

    @JsonProperty("presence_penalty")
    private Double presencePenalty;

    @JsonProperty("frequency_penalty")
    private Double frequencyPenalty;

    @JsonProperty("logit_bias")
    private Map<String, Integer> logitBias;

    private String user;

    public MultiChatRequest(String model, List<MultiChatMessage> messages, Integer maxTokens, Double temperature, Double topP) {
        this.model = model;
        this.messages = messages;
        this.maxTokens = maxTokens;
        this.temperature = temperature;
        this.topP = topP;
    }
}
