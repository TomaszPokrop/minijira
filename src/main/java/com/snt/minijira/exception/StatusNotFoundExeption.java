package com.snt.minijira.exception;

public class StatusNotFoundExeption extends RuntimeException{
    public StatusNotFoundExeption(String message) {
        super(message);
    }
}
