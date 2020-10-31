package com.backend.apiserver.exception;

import com.backend.apiserver.response.ResponseMessage;
import lombok.Getter;

@Getter
public class BadRequestException extends Exception {
    private String code;

    public BadRequestException(final ResponseMessage responseMessage, Object... params) {
        super(responseMessage.getMessage(params));
        this.code = responseMessage.getCode();
    }
}
