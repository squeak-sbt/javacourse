package ru.sbt.lesson7;

public class MainVolatile {
    private volatile boolean keepRunning = true;
    public void run(){
        int counter = 0;
        while (keepRunning) {
            ++counter;
        }
        System.out.println(counter);
    }
    public void stop(){
        keepRunning = false;
    }

    public static void main(String[] args) throws InterruptedException {
        MainVolatile mainVolatile = new MainVolatile();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                mainVolatile.run();
            }
        });
        t1.start();
        Thread.sleep(1);
        mainVolatile.stop();

        System.out.println("Main finish");
    }
}
