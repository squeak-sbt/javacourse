package ru.sbt.homework5.exception;


public class AccounIsLockedException extends Throwable {
    private final int remainingSeconds;

    public AccounIsLockedException(int remainingSeconds) {
        this.remainingSeconds = remainingSeconds;
    }

    public int getRemainingSeconds() {
        return remainingSeconds;
    }
}
