package com.solmaztravel.demo.exception;

public class SolmazTravelException extends RuntimeException{
    private String key;

    public SolmazTravelException(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
