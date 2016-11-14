package ru.sbt.lesson7.runnablemanager;

import org.junit.Test;

import static org.junit.Assert.*;

public class RunnableManagerTest {
    @Test
    public void runTest(){
        RunnableManager manager = new RunnableManagerImpl();
        try {
            manager.run(new Callback(), new Runnable[]{new Worker(), new Worker(), new Worker(), new Worker()});
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}