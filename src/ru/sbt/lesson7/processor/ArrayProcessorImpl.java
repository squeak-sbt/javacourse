package ru.sbt.lesson7.processor;

public class ArrayProcessorImpl implements ArrayProcessor {
    @Override
    public int[] process(int[] original, ElementStrategy strategy, int threadCount) throws InterruptedException {
        int partSize = original.length / threadCount;
        int[] copy = original.clone();
        Thread[] threads = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(new ProcessPart(i * partSize, i == threadCount - 1 ? original.length : (i + 1) * partSize, copy, strategy));
            threads[i].start();
        }
        for (int i = 0; i < threadCount; i++) {
            threads[i].join();
        }
        return copy;
    }
}
