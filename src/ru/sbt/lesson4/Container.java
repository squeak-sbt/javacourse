package ru.sbt.lesson4;

public interface Container<E> {
    void add(E e);
    E get(int index);
    int size();
}
