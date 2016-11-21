package ru.sbt.lesson8;

public interface TaskManager {
    Context execute(Runnable... runnables);
}
