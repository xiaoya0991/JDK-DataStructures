package com.jdk.data.structures.jdkdatastructures.shengjie.stack;

import com.jdk.data.structures.jdkdatastructures.shengjie.array.ArrayDemo;

public class ArrayStackDemo<E> implements StackDemo<E> {
    /**
     * define an array
     */
    ArrayDemo<E> array;

    /**
     * construction with parameters
     * @param capacity
     */
    public ArrayStackDemo(int capacity){
        array = new ArrayDemo<>(capacity);
    }

    /**
     * construction without parameters
     */
    public ArrayStackDemo(){
        array = new ArrayDemo<>();
    }

    /**
     * get the size
     * @return the size value
     */
    @Override
    public int getSize(){
        return array.getSize();
    }

    /**
     * empty handle
     * @return
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * get the capacity
     * @return the capacity value
     */
    public int getCapacity(){
        return array.getCapacity();
    }

    /**
     * add an element to the stack
     * @param e
     */
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    /**
     * get an element of stack
     * @return
     */
    @Override
    public E pop() {
        return array.removeLast();
    }

    /**
     * get the top element of stack
     * @return
     */
    @Override
    public E peek() {
        return array.getLast();
    }

    /**
     * override toString method
     * @return
     */
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("stack: [");
        for(int i = 0; i < array.getSize(); i++){
            stringBuilder.append(array.get(i));
            if(i != array.getSize() - 1){
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("] top");

        return stringBuilder.toString();
    }
}
