package com.model.chatgpt.config.properties;

import com.model.chatgpt.config.YamlPropertySourceFactory;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author Richa Pokhrel
 */
@Getter
@Setter
@Component
@ToString
@ConfigurationProperties(prefix = "chat")
@PropertySource(factory = YamlPropertySourceFactory.class, value = "classpath:chat.yml")
public class ChatProperties {

    private String url;
    private Integer maxTokens;
    private String model;
    private Double temperature;
    private Double topP;

}
