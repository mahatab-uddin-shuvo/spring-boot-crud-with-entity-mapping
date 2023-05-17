package com.example.employeemicroservice.exception;

import java.sql.SQLIntegrityConstraintViolationException;

public class SQLIntegrityException extends SQLIntegrityConstraintViolationException {
    public SQLIntegrityException(String message){
        super(message);
    }
}
