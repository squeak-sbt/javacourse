package ru.sbt.homework3;


import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new TreeMap<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int cur = in.nextInt();
            switch (cur) {
                case 1:
                    int key = in.nextInt();
                    Integer count = map.get(key);
                    if (count == null) {
                        map.put(key, 1);
                    } else {
                        map.put(key, count + 1);
                    }
                    break;
                case 2:
                    int pop_key = map.keySet().iterator().next();
                    System.out.println(pop_key);
                    if (map.get(pop_key) > 1) {
                        map.put(pop_key, map.get(pop_key) - 1);
                    } else {
                        map.remove(pop_key);
                    }
                    break;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }
}
