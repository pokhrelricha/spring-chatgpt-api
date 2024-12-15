package com.model.chatgpt.exception;

import com.model.chatgpt.constant.ResponseCodeConstant;
import com.model.chatgpt.dto.response.ServerResponse;

/**
 * @author Richa Pokhrel
 */
public class ChatGPTServerException extends RuntimeException {

    private ServerResponse serverResponse;

    public ChatGPTServerException(){
        super();
    }

    public ChatGPTServerException(String message){
        super(message);
    }

    public ServerResponse getServerResponse(String message) {

        if (serverResponse == null) {
            return new ServerResponse(false, ResponseCodeConstant.FAILURE, message);
        }
        return serverResponse;
    }

    public ServerResponse getServerResponse() {
        if (serverResponse == null) {
            return new ServerResponse(false, ResponseCodeConstant.FAILURE, "No Response");
        }
        return serverResponse;
    }

}
