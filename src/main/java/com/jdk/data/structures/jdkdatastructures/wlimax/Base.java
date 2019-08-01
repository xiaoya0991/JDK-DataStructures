package com.jdk.data.structures.jdkdatastructures.wlimax;

public interface Base<E> {
    void clera();

    int size();

    boolean isEmpty();

    boolean contains(E element);

    void addLast(E element);
    void addFirst(E element);

    E get(int index);

    E set(int index, E element);

    void add(int index, E element);

    E remove(int index);

    int find(E element);

}
