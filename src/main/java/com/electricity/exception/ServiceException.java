package com.electricity.exception;

import lombok.Getter;

@Getter
public class ServiceException extends RuntimeException {

    private String key;

    private String entity;

    private Object[] params;

    public ServiceException(String key, String message, String entity){
        super(message);
        this.key = key;
        this.entity = entity;
    }

    public ServiceException(String key, String message, String entity, Object[] params){
        super(message);
        this.key = key;
        this.entity = entity;
        this.params = params;
    }
}
