package ru.sbt.lesson3;


import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, Integer> map = new TreeMap<>();
        while (in.hasNext()) {
            String cur = in.next().toLowerCase();
            Integer count = map.get(cur);
            if (count == null) {
                map.put(cur, 1);
            }
            else {
                map.put(cur, count + 1);
            }
        }
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxCount) {
                System.out.println(entry.getKey());
            }
        }
    }
}
