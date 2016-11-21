package ru.sbt.lesson8;

import java.util.concurrent.Callable;

public class Task<T> {
    private final Callable<T> callable;
    private Exception exception;
    private T result;
    private volatile boolean finished;

    public Task(Callable<T> callable) {
        this.callable = callable;
    }

    public T get() throws Exception {
        if (!finished) {
            synchronized (this) {
                if (!finished) {
                    try {
                        result = callable.call();
                    } catch (Exception e) {
                        exception = e;
                        throw e;
                    } finally {
                        finished = true;
                    }
                }
            }
        }
        if (exception != null) throw exception;
        return result;

    }
}
