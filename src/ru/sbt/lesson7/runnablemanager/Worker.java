package ru.sbt.lesson7.runnablemanager;

public class Worker implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(10);
            System.out.println("Worker " + Thread.currentThread().getName() + " finished his work!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
