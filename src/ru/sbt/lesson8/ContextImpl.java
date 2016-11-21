package ru.sbt.lesson8;

public class ContextImpl implements Context {
    private volatile int success = 0;
    private volatile int failed = 0;

    public ContextImpl() {
    }

    @Override
    public int getFinishedTaskCount() {
        return success + failed;
    }

    @Override
    public int getFailedTaskCount() {
        return failed;
    }

    @Override
    public int getSuccessfinishedTaskCount() {
        return success;
    }

    @Override
    public void stop() {

    }

    @Override
    public synchronized void incrementFailedTask() {
        success++;
    }

    @Override
    public synchronized void incrementSuccessTask() {
        failed++;
    }
}
