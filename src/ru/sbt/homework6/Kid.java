package ru.sbt.homework6;


public class Kid {
    private String toys;
    private int age;
    private String name;

    public String getToys() {
        return toys;
    }

    public void setToys(String toys) {
        this.toys = toys;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Kid{" +
                "toys='" + toys + '\'' +
                '}';
    }
}
