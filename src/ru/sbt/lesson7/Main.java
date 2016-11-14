package ru.sbt.lesson7;

import ru.sbt.lesson7.processor.ArrayProcessor;
import ru.sbt.lesson7.processor.ArrayProcessorImpl;
import ru.sbt.lesson7.processor.MyElementStrategy;
import ru.sbt.lesson7.runnablemanager.Callback;
import ru.sbt.lesson7.runnablemanager.RunnableManager;
import ru.sbt.lesson7.runnablemanager.RunnableManagerImpl;
import ru.sbt.lesson7.runnablemanager.Worker;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ArrayProcessor processor = new ArrayProcessorImpl();
        int[] array = new int[50];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        ArrayProcessor.ElementStrategy strategy = new MyElementStrategy();
        int[] newArray = processor.process(array, strategy, 3);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(newArray[i] + " ");
        }

        RunnableManager manager = new RunnableManagerImpl();
        manager.run(new Callback(), new Runnable[]{new Worker(), new Worker(), new Worker(), new Worker(), new Worker(), new Worker()});
    }
}
