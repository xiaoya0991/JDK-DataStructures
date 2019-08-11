package com.jdk.data.structures.jdkdatastructures.shengjie.queue;

import com.jdk.data.structures.jdkdatastructures.shengjie.arrayList.ArrayDemo;

/**
 * write a queue class
 *
 * @author Holy
 */
public class ArrayQueueDemo<E> implements QueueDemo<E>{
    /**
     * define an arrayList
     */
    ArrayDemo<E> array;

    /**
     * construction without parameters
     */
    public ArrayQueueDemo(){
        this.array = new ArrayDemo<>();
    }

    /**
     * construction with parameters
     * @param capacity
     */
    public ArrayQueueDemo(int capacity){
        this.array = new ArrayDemo<>(capacity);
    }

    /**
     * get the size
     * @return the size value
     */
    @Override
    public int getSize() {
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
     * enter the queue
     * @param o an object
     */
    @Override
    public void enqueue(Object o) {
        this.array.addLast((E) o);
    }

    /**
     * out of the queue
     * @return an object
     */
    @Override
    public E dequeue() {
        return this.array.removeFirst();
    }

    /**
     * get the head object of the queue
     * @return
     */
    @Override
    public E getFront() {
        return this.array.getFirst();
    }

    /**
     * override toString method
     * @return
     */
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("queue head : [");
        for(int i = 0; i < this.array.getSize(); i++){
            stringBuilder.append(this.array.get(i));
            if(i != this.array.getSize() - 1){
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("] tail");

        return stringBuilder.toString();
    }
}
