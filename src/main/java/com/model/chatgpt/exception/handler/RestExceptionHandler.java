package com.model.chatgpt.exception.handler;

import com.model.chatgpt.dto.response.ServerResponse;
import com.model.chatgpt.exception.ChatGPTServerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Richa Pokhrel
 */
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@SuppressWarnings("Duplicates")
public class RestExceptionHandler {

    @ExceptionHandler(ChatGPTServerException.class)
    protected ResponseEntity<Object> handleInvalidDataException(ChatGPTServerException ex) {
        log.error("Exception message : {}", ex.getMessage());

        if (log.isDebugEnabled()) {
            log.error("Exception : ", ex);
        }
        return buildResponseEntity(ex.getServerResponse(), HttpStatus.NOT_ACCEPTABLE);
    }


    private ResponseEntity<Object> buildResponseEntity(ServerResponse serverResponse, HttpStatus httpStatus) {
        return new ResponseEntity<>(serverResponse, httpStatus);
    }
}
