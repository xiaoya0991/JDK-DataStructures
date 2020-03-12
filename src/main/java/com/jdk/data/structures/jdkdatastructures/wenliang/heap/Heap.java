package com.jdk.data.structures.jdkdatastructures.wenliang.heap;

/**
 * 二叉堆接口
 *
 * @author wenliang
 */
public interface Heap<E> {

    int size();

    boolean isEmpty();

    void clear();

    void add(E element);

    E get();

    E remove();

    E replacee(E element);

}
