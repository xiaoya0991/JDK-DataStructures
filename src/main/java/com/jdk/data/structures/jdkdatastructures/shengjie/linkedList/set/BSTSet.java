package com.jdk.data.structures.jdkdatastructures.shengjie.linkedList.set;

import com.jdk.data.structures.jdkdatastructures.wenliang.tree.BST;

public class BSTSet<E extends Comparable<E>> implements Set<E> {
    private BST<E> bst;

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }
}
