package ru.sbt.lesson8;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Runnable[] runnables = new Runnable[20];
        for (int i = 0; i < 20; i++) {
            int finalI = i;
            runnables[i] = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (new Random().nextBoolean()) {
                        throw new RuntimeException();
                    }
                    //System.out.println("Runnable " + finalI);
                }
            };
        }
        TaskManager taskManager = new TaskManagerImpl();
        Context context = taskManager.execute(runnables);
        for (int i = 0; i < 10; i++) {
            System.out.println("------------------");
            System.out.println("finished: " + context.getFinishedTaskCount());
            System.out.println("failed: " + context.getFailedTaskCount());
            System.out.println("success: " + context.getSuccessfinishedTaskCount());
            System.out.println("------------------");
            Thread.sleep(500);
        }
    }
}
