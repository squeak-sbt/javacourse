package ru.sbt.lesson8;

public interface Context {
    int getFinishedTaskCount();

    int getFailedTaskCount();

    int getSuccessfinishedTaskCount();

    void stop();

    void incrementFailedTask();

    void incrementSuccessTask();
}
