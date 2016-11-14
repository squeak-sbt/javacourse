package ru.sbt.lesson7.threadpool;

import java.util.ArrayList;
import java.util.List;

public class ThreadPool {
    private final List<Runnable> runnables = new ArrayList<>();

    public void start(int count){
        for (int i = 0; i < count; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        synchronized (this) {
                            if (!runnables.isEmpty()) {
                                Runnable runnable = runnables.remove(0);
                                System.out.println("Thread " + Thread.currentThread().getName() + ": Running task " + runnable.toString());
                                runnable.run();
                            }
                            else {
                                try {
                                    wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }).start();
        }
    }

    public void execute(Runnable runnable) {
        synchronized (this) {
            runnables.add(runnable);
            notify();
        }
    }
}
