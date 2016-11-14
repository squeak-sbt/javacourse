package ru.sbt.lesson7.runnablemanager;

import java.util.ArrayList;
import java.util.List;

public class RunnableManagerImpl implements RunnableManager {
    @Override
    public void run(Runnable callback, Runnable... tasks) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                List<Thread> threads = new ArrayList<>();
                for (int i = 0; i < tasks.length; i++) {
                    Thread t = new Thread(tasks[i]);
                    threads.add(t);
                    t.start();
                }
                for (Thread thread : threads) {
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                callback.run();
            }
        });
        thread.start();
    }
}
