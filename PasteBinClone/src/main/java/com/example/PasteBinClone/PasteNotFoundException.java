package com.example.PasteBinClone;

public class PasteNotFoundException extends Throwable{
    public PasteNotFoundException(String message) {
        super(message);
    }
}
