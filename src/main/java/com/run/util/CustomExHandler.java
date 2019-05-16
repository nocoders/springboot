package com.run.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestControllerAdvice
public class CustomExHandler {
    private static final Logger LOG = LoggerFactory.getLogger(CustomExHandler.class);
    @ExceptionHandler
    Object handleExecption(Exception e, HttpServletRequest request){
        LOG.error("url {},msg {}",request.getRequestURL(),e.getMessage());
        HashMap<String, Object> map = new HashMap<>();
        map.put("code",100);
        map.put("message",e.getMessage());
        map.put("url",request.getRequestURL());
        return map;
    }
}
