package com.example.employeemicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorMessage {

    private Date timeStamp;
    private int statusCode;
    private String error;
    private String message;
}
