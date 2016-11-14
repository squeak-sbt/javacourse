package ru.sbt.lesson7.processor;

public class ProcessPart implements Runnable {
    private int start, end;
    private int[] array;
    private ArrayProcessor.ElementStrategy strategy;

    public ProcessPart(int start, int end, int[] array, ArrayProcessor.ElementStrategy strategy) {
        this.start = start;
        this.end = end;
        this.array = array;
        this.strategy = strategy;
    }

    @Override
    public void run() {
        for (int i = this.start; i < this.end; i++) {
            array[i] = strategy.process(array[i]);
        }
    }
}
