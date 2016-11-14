package ru.sbt.homework6;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(20);
        Kid kid = new Kid();
        kid.setName("Aaa");
        BeanUtils.assign(kid, person);
        System.out.println(person.toString());
    }
}
