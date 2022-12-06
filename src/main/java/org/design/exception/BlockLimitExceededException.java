package org.design.exception;

public class BlockLimitExceededException extends Exception{

    public BlockLimitExceededException(String message){
        super(message);
    }
}
