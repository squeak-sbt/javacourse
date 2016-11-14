package ru.sbt.homework4;

/**
 * Created by dmitry on 23.10.16.
 */
public class Main {
    public static void main(String[] args) {
        CountMap<Integer> map = new CountMapImpl<>();
        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);
        System.out.println(map.getCount(5));
        System.out.println(map.getCount(6));
    }
}
