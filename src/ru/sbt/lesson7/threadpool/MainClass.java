package ru.sbt.lesson7.threadpool;

public class MainClass {
    public static void main(String[] args) {
        ThreadPool pool = new ThreadPool();
        pool.start(4);
        for (int i = 0; i < 100; i++) {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
