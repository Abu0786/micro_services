package com.hm.user.service.exceptions;

public class ResourceNotFoundExceptions extends RuntimeException{
    //extra properties that you want to manage
    public ResourceNotFoundExceptions(){
        super("Resource not found on server !!");
    }

    public ResourceNotFoundExceptions(String message){
        super(message);
    }
}
