package com.model.chatgpt.dto;

import lombok.*;

/**
 * @author Richa Pokhrel
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    private String role;
    //prompt
    private String content;

}
