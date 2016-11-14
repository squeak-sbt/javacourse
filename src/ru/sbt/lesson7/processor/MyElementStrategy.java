package ru.sbt.lesson7.processor;

public class MyElementStrategy implements ArrayProcessor.ElementStrategy {
    @Override
    public int process(int i) {
        return i * i * i;
    }
}
