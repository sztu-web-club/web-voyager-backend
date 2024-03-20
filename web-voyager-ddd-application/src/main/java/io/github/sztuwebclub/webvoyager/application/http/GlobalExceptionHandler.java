package io.github.sztuwebclub.webvoyager.application.http;

import io.github.sztuwebclub.webvoyager.constant.ResponseCode;
import io.github.sztuwebclub.webvoyager.constant.model.BaseException;
import io.github.sztuwebclub.webvoyager.constant.model.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.Serializable;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 捕获业务异常
     * @param ex
     * @return
     */
    @ExceptionHandler
    public Response<Serializable> exceptionHandler(BaseException ex) {
        log.error("异常信息：{}", ex.getMessage());
        return Response.builder()
                .code(ResponseCode.UN_ERROR.getCode())
                .info(ResponseCode.UN_ERROR.getInfo())
                .data(ex.getMessage())
                .build();
    }
}