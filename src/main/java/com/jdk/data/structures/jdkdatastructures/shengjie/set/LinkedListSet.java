package com.jdk.data.structures.jdkdatastructures.shengjie.set;

import com.jdk.data.structures.jdkdatastructures.shengjie.linkedList.LinkedList;

public class LinkedListSet<E> implements Set<E> {
    LinkedList linkedList = new LinkedList();

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void add(E e) {
        if(!contains(e))
            linkedList.addFirst(e);
    }

    @Override
    public void remove(E e) {
        linkedList.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return false;
    }
}
