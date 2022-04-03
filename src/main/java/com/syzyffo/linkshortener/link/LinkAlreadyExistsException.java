package com.syzyffo.linkshortener.link;

public class LinkAlreadyExistsException extends RuntimeException{

    public LinkAlreadyExistsException(String id){
        super("Link id " +id+ " już istnieje");
    }

}
