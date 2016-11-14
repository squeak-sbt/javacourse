package ru.sbt.lesson7.runnablemanager;

public interface RunnableManager {
    void run(Runnable callback, Runnable... tasks) throws InterruptedException;
}
