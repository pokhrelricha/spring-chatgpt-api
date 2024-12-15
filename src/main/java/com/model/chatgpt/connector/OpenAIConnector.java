package com.model.chatgpt.connector;

import com.model.chatgpt.exception.ChatGPTServerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author Richa Pokhrel
 */
@Slf4j
@Component
public class OpenAIConnector {

    @Value("${openai.api.key}")
    private String OPENAI_KEY;

    @Autowired
    private RestTemplate restTemplate;

    public <T> T response(HttpEntity<?> httpEntity, Class<T> responseType, String url) {
        log.debug("Triggering url: {}, with httpEntity: {}", url, httpEntity);

        ResponseEntity<T> responseEntity = restTemplate.postForEntity(url, httpEntity, responseType);

        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            log.error("Connection Error Occurred while Triggering URL: {}, with Error Response: {}", url, responseEntity);
            throw new ChatGPTServerException("Error Response Status :" + responseEntity.getStatusCode().value());
        }

        log.info("Response: {}", responseEntity);
        return responseEntity.getBody();
    }


    public <T> HttpEntity<?> buildHttpEntity(T request) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(MediaType.APPLICATION_JSON_UTF8_VALUE));
        headers.add(HttpHeaders.AUTHORIZATION, OPENAI_KEY);
        return new HttpEntity<>(request, headers);
    }

}
