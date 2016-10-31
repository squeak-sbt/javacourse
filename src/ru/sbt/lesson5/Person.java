package ru.sbt.lesson5;

public class Person {
    private String name;
    public String date;

    public Person(String name, String date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }
}
