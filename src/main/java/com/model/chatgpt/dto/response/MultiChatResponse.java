package com.model.chatgpt.dto.response;

import com.model.chatgpt.dto.Usage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Richa Pokhrel
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MultiChatResponse {
    private boolean success;
    private String id;
    private String object;
    private LocalDate created;
    private String model;
    private List<MultiResponseChoice> choices;
    private Usage usage;
}
