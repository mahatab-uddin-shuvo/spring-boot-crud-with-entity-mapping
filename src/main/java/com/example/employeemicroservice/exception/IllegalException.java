package com.example.employeemicroservice.exception;

public class IllegalException extends IllegalArgumentException{
    public IllegalException(String message){
        super(message);
    }
}
