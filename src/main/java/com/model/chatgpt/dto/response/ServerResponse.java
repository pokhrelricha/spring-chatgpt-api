package com.model.chatgpt.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Richa Pokhrel
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ServerResponse<T> {
    private boolean success;
    private Integer code;
    private String message;
    private T data;
    private Object errors;

    public ServerResponse(boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
}
