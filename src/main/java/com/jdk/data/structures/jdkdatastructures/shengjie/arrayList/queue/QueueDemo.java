package com.jdk.data.structures.jdkdatastructures.shengjie.arrayList.queue;

/**
 * queue interface
 *
 * @author Holy
 * @create 2019 - 08 - 08 7:34
 */
public interface QueueDemo<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
