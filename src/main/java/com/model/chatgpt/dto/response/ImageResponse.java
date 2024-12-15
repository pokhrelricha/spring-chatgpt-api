package com.model.chatgpt.dto.response;

import com.model.chatgpt.dto.ImageData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author Richa Pokhrel
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageResponse {

    private Date created;

    private List<ImageData> data;
}
