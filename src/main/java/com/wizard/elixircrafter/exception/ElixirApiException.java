package com.wizard.elixircrafter.exception;

public class ElixirApiException extends RuntimeException {
    public ElixirApiException(String message, Throwable cause) {
        super(message, cause);
    }
}