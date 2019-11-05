package com.jdk.data.structures.jdkdatastructures.shengjie.arrayList.stack;

import com.jdk.data.structures.jdkdatastructures.shengjie.arrayList.ArrayDemo;

public class ArrayStackDemo<E> implements StackDemo<E> {
    /**
     * define an arrayList
     */
    ArrayDemo<E> array;

    /**
     * construction with parameters
     * @param capacity
     */
    public ArrayStackDemo(int capacity){
        this.array = new ArrayDemo<>(capacity);
    }

    /**
     * construction without parameters
     */
    public ArrayStackDemo(){
        this.array = new ArrayDemo<>();
    }

    /**
     * get the size
     * @return the size value
     */
    @Override
    public int getSize(){
        return this.array.getSize();
    }

    /**
     * empty handle
     * @return
     */
    @Override
    public boolean isEmpty() {
        return this.array.isEmpty();
    }

    /**
     * get the capacity
     * @return the capacity value
     */
    public int getCapacity(){
        return this.array.getCapacity();
    }

    /**
     * add an element to the stack
     * @param e
     */
    @Override
    public void push(E e) {
        this.array.addLast(e);
    }

    /**
     * get an element of stack
     * @return
     */
    @Override
    public E pop() {
        return this.array.removeLast();
    }

    /**
     * get the top element of stack
     * @return
     */
    @Override
    public E peek() {
        return this.array.getLast();
    }

    /**
     * override toString method
     * @return
     */
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("stack: [");
        for(int i = 0; i < this.array.getSize(); i++){
            stringBuilder.append(this.array.get(i));
            if(i != this.array.getSize() - 1){
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("] top");

        return stringBuilder.toString();
    }
}
