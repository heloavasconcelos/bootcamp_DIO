package com.project.Bootcamp.exceptions;

import com.project.Bootcamp.util.MessageUtils;

public class NotFoundExceptions extends RuntimeException{
    public NotFoundExceptions(){
        super(MessageUtils.NO_RECORDS_FOUND);
    }
}
