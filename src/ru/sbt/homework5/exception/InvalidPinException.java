package ru.sbt.homework5.exception;


public class InvalidPinException extends Throwable {
    private final int remainingAttempts;

    public InvalidPinException(int remainingAttempts) {
        this.remainingAttempts = remainingAttempts;
    }

    public int getRemainingAttempts() {
        return remainingAttempts;
    }
}
