package com.model.chatgpt.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Richa Pokhrel
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompletionRequest {

    private String model;        // The model to use, e.g., "text-davinci-003".
    private String prompt;       // The input prompt.
    private Integer max_tokens;  // Maximum number of tokens to generate.
    private Double temperature;  // Sampling temperature.
    private Double top_p;        // Nucleus sampling parameter.
}
