package com.db.assignment.assignment.exception;

import lombok.Data;

@Data
public class NaceNotFoundException extends Exception{


    private String errorMessage;

    public NaceNotFoundException( String errorMessage) {

        this.errorMessage = errorMessage;
    }
}
