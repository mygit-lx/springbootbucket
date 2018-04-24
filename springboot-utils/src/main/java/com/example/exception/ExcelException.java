package com.example.exception;

public class ExcelException extends Exception {

    private String message;
    private Throwable cause;

    public ExcelException() {
    }

    public ExcelException(String message) {
        super(message);
        this.message = message;
    }

    public ExcelException(Throwable cause) {
        super(cause);
        this.cause=cause;
    }

    public ExcelException(String message, Throwable cause) {
        super(message, cause);
        this.message=message;
        this.cause=cause;
    }


}
