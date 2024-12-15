package com.model.chatgpt.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Richa Pokhrel
 */
@Data
public class ImageData {

    private String url;

    @JsonProperty("b64_json")
    private String b64Json;
}
