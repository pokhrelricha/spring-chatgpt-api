package com.model.chatgpt.dto.request;

import com.model.chatgpt.dto.Message;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Richa Pokhrel
 */
@Getter
@Setter
@ToString
public class ChatGPTRequest {

    private String model;
    private List<Message> messageList;

    public ChatGPTRequest(String model, String prompt) {
        this.model = model;
        this.messageList = new ArrayList<>();
        this.messageList.add(new Message("USER", prompt));
    }
}
