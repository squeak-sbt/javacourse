package ru.sbt.lesson7.processor;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayProcessorImplTest {
    @Test
    public void process() throws Exception {
        int[] array = new int[50];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        int[] expected = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            expected[i] = array[i] + 5;
        }
        ArrayProcessor processor = new ArrayProcessorImpl();
        int[] result = processor.process(array, i -> i + 5, 5);
        for (int i = 0; i < array.length; i++) {
            assertEquals(result[i], expected[i]);
        }
    }
}