package com.model.chatgpt.connector;

import com.model.chatgpt.dto.request.MultiChatRequest;
import com.model.chatgpt.dto.response.MultiChatResponse;
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

    public <T> T getResponse(HttpEntity<?> httpEntity, Class<T> responseType, String url) {
        log.info("request url: {}, httpEntity: {}", url, httpEntity);
        ResponseEntity<T> responseEntity = restTemplate.postForEntity(url, httpEntity, responseType);
        if (responseEntity.getStatusCodeValue() != HttpStatus.OK.value()) {
            log.error("error response status: {}", responseEntity);
            throw new RuntimeException("error response status :" + responseEntity.getStatusCodeValue());
        } else {
            log.info("response: {}", responseEntity);
        }
        return responseEntity.getBody();
    }


    public <T> HttpEntity<?> buildHttpEntity(T request) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(MediaType.APPLICATION_JSON_UTF8_VALUE));
        headers.add(HttpHeaders.AUTHORIZATION, OPENAI_KEY);
        return new HttpEntity<>(request, headers);
    }

}
