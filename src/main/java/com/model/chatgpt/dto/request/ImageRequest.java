package com.model.chatgpt.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Richa Pokhrel
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImageRequest {

    private String prompt;
    private Integer n;
    private String size;

    @JsonProperty("response_format")
    private String responseFormat;

    private String user;

    public ImageRequest(String prompt) {
        this.prompt = prompt;
    }
}
