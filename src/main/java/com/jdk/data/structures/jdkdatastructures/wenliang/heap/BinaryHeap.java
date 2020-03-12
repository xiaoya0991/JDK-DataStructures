package com.jdk.data.structures.jdkdatastructures.wenliang.heap;

import java.util.Comparator;

/**
 * 二叉堆
 *
 * @author wenliang
 */
public class BinaryHeap<E> implements Heap<E> {

    private E[] elements;
    private int size;
    private Comparator<E> comparator;
    private static final int DEFAULT_CAPACITY = 10;


    public BinaryHeap(Comparator<E> comparator) {
        this.comparator = comparator;
        this.elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public BinaryHeap() {
        this(null);
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }

    }

    @Override
    public void add(E element) {

    }

    @Override
    public E get() {
        return null;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E replacee(E element) {
        return null;
    }

    private int compare(E e1, E e2) {
        return comparator != null ? comparator.compare(e1, e2) :
                ((Comparable<E>) e1).compareTo(e2);
    }


}
