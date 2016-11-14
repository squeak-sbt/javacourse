package ru.sbt.lesson7.runnablemanager;

public class Callback implements Runnable {
    @Override
    public void run() {
        System.out.println("Callback finished!");
    }
}
