package com.model.chatgpt.dto.request;

import lombok.*;

import java.util.List;

/**
 * @author Richa Pokhrel
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MultiChatMessageList {

    private List<MultiChatMessage> multiChatMessageList;
}
