package com.jdk.data.structures.jdkdatastructures.shengjie;

public interface Base<E> {

    int size();

    boolean isEmpty();

    boolean contains(E element);

    int getSize();

    int getCapacity();

    E get(int index);

    void set(int index, E element);

    void add(int index, E element);

    E remove(int index);
}

