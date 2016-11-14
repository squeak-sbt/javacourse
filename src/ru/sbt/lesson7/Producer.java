package ru.sbt.lesson7;

import java.util.ArrayList;
import java.util.List;

public class Producer {
    private final List<Integer> strings = new ArrayList<>();

    public void producer(){
        int i = 0;
        while (true) {
            synchronized (this) {
                if(strings.size() > 10000) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                strings.add(++i);
                notify();
            }
        }
    }
    public void consumer(){
        while(true) {
            synchronized (this) {
                while (strings.isEmpty()) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
