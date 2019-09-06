package com.jdk.data.structures.jdkdatastructures.shengjie;

public abstract class AbstractImpl<E> implements Base<E> {
    private int size;
    private int capacity;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E element) {
        return false;
    }

    @Override
    public int getSize(){ return size; }

    @Override
    public int getCapacity(){ return capacity; }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public void set(int index, E element) {
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
    }
}
