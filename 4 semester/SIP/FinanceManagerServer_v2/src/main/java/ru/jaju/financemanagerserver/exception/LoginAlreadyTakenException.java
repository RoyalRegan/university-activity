package ru.jaju.financemanagerserver.exception;

public class LoginAlreadyTakenException extends RuntimeException {
    public LoginAlreadyTakenException() {
        super("Login already taken");
    }
}
