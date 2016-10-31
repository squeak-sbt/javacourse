package ru.sbt.lesson4;

import java.util.List;

public interface Container<E> {
    void add(E e);
    E get(int index);
    void addAll(Container<? super E> source);
    void addInto(Container<? super E> destination);
    List<? extends E> toList();
    int size();
}
