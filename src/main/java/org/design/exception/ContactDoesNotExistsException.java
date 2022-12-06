package org.design.exception;

public class ContactDoesNotExistsException extends Exception{
    public ContactDoesNotExistsException(String message){
        super(message);
    }
}
