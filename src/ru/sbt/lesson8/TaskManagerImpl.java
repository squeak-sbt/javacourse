package ru.sbt.lesson8;

public class TaskManagerImpl implements TaskManager {
    @Override
    public Context execute(Runnable... runnables) {
        Context context = new ContextImpl();
        for (Runnable runnable : runnables) {
            Thread thread = new Thread(new RunnableWithContext(context, runnable));
            thread.start();
        }
        return context;
    }
}
