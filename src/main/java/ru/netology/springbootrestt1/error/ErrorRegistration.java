package ru.netology.springbootrestt1.error;


public class ErrorRegistration extends RuntimeException{
    public ErrorRegistration(String msg) {
        super(msg);
    }
}