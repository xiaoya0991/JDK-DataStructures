package com.jdk.data.structures.jdkdatastructures.shengjie.arrayList.stack;

/**
 * stack interface defined by self
 * @param <E>
 */
public interface StackDemo<E> {
    /**
     * get the size
     * @return
     */
    int getSize();

    /**
     * judge the stack has elements
     * @return
     */
    boolean isEmpty();

    /**
     * add an element to the stack
     * @param e
     */
    void push(E e);

    /**
     * get an element of stack
     * @return
     */
    E pop();

    /**
     * get the top element of stack
     * @return
     */
    E peek();
}
