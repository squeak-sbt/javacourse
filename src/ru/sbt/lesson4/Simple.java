package ru.sbt.lesson4;


import java.util.Comparator;
import java.util.List;

public class Simple {
    public static void main(String[] args) {

    }
    //PECS
    // Producer = extends
    // Consumer = super
    public static void print(List<Number> numbers){
        for (Number number : numbers) {
            System.out.println(number);
        }
    }
    public static <T> T max(List<? extends T> list, Comparator<? super T> comparator) {
        T max = list.get(0);
        for (T t : list) {
            if (comparator.compare(max, t) < 0) {
                max = t;
            }
        }
        return max;
    }
}
