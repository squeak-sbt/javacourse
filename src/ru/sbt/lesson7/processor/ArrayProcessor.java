package ru.sbt.lesson7.processor;

public interface ArrayProcessor {
    int[] process(int [] original,
                  ElementStrategy strategy,
                  int threadCount) throws InterruptedException;
    interface ElementStrategy {
        int process(int i);
    }
}
