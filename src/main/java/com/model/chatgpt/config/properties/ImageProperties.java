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
@ConfigurationProperties(prefix = "image")
@PropertySource(factory = YamlPropertySourceFactory.class, value = "classpath:image.yml")
public class ImageProperties {

    private String url;
    private Integer number;
    private String model;
}
