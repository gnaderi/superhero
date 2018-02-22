package com.gnaderi.superhero;

public class SuperheroException extends RuntimeException {

    public SuperheroException(String message) {
        super(message);
    }

    public SuperheroException(String message, Throwable cause) {
        super(message, cause);
    }
}