package ru.sbt.lesson4;

import java.util.ArrayList;
import java.util.List;

public class FixedSizeContainer<E> implements Container<E> {
    private final Object[] objects;
    private int size;

    public FixedSizeContainer(int size) {
        this.objects = new Object[size];
    }

    @Override
    public void add(E o) {
        this.objects[size++] = o;
    }

    @Override
    public E get(int index) {
        return (E)objects[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void addAll(Container<? super E> source) {
        for (int i = 0; i < source.size(); i++) {
            this.add((E)source.get(i));
        }
    }

    @Override
    public void addInto(Container<? super E> destination) {
        for (int i = 0; i < size; i++) {
            destination.add((E)objects[i]);
        }
    }

    @Override
    public List<? extends E> toList() {
        List<E> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add((E)objects[i]);
        }
        return list;
    }
}
