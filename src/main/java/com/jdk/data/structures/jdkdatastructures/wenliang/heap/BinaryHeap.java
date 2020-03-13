package com.jdk.data.structures.jdkdatastructures.wenliang.heap;

import java.util.Comparator;
import org.omg.CORBA.Object;

/**
 * 二叉堆
 *
 * @author wenliang
 */
public class BinaryHeap<E> extends AbstractHeap<E> {

    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;


    public BinaryHeap(E[] elements, Comparator<E> comparator) {
        super(comparator);
        if (elements == null || elements.length == 0) {
            this.elements = (E[]) new Object[DEFAULT_CAPACITY];
        }
        size = elements.length;
        int capacity = Math.max(elements.length, DEFAULT_CAPACITY);
        elements = (E[]) new Object[capacity];
        for (int i = 0; i < elements.length; i++) {
            this.elements[i] = elements[i];
        }
    }

    public BinaryHeap(E[] elements) {
        this(elements, null);
    }

    public BinaryHeap(Comparator<E> comparator) {
        this(null, comparator);
    }

    public BinaryHeap() {
        this(null, null);
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
        elemeentNotNullCheck(element);
        ensureCapacity(size + 1);
        siftUp(size - 1);

    }

    @Override
    public E get() {
        emptyCheck();
        return elements[0];
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E replacee(E element) {
        return null;
    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) {
            return;
        }
        //新容量为旧容量的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < this.size; i++) {
            newElements[i] = this.elements[i];
        }
        this.elements = newElements;
    }


    private void siftUp(int index) {
        E e = elements[index];
        while (index > 0) {
            int pindex = (index - 1) >> 1;
            E p = elements[pindex];
            if (compare(e, p) <= 0) {
                return;
            }
            E tmp = elements[index];
            elements[index] = elements[pindex];
            elements[pindex] = tmp;
            index = pindex;
        }
    }

    private void emptyCheck() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("heap is empty");
        }
    }

    private void elemeentNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be empty");
        }
    }

}
