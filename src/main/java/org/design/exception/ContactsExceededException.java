package org.design.exception;

public class ContactsExceededException extends Exception{
    public ContactsExceededException(String message){
        super(message);
    }
}
