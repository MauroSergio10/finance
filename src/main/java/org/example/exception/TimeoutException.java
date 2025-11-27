package org.example.exception;

public class TimeoutException extends CustomException{
    public TimeoutException(String message){
        super("message", "504");
    }
}
