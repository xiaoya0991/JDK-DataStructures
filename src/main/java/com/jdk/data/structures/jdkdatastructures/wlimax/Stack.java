package com.jdk.data.structures.jdkdatastructures.wlimax;

public interface Stack<E> {
    boolean isEmpty();
    E peek();
    E pop();
    void push(E e);
    int getSize();
}
