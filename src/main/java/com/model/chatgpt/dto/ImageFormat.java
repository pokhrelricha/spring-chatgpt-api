package com.model.chatgpt.dto;

/**
 * @author Richa Pokhrel
 */
public enum ImageFormat {

    URL("url"),BASE64("b64_json");

    private final String format;

    ImageFormat(String format){
        this.format = format;
    }

    public String getFormat(){
        return format;
    }

}
