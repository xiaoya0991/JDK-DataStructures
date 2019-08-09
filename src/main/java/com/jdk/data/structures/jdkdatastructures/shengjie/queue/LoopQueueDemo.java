package com.jdk.data.structures.jdkdatastructures.shengjie.queue;

public class LoopQueueDemo<E> implements QueueDemo<E>{

    private E[] data;

    private int front;

    private int tail;

    private int size;

    public LoopQueueDemo(int capacity){
        data = (E[]) new Object[capacity + 1];//need more a length
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueueDemo(){
        this(10);
    }

    public int getCapacity(){
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(Object o) {

    }

    @Override
    public E dequeue() {
        return null;
    }

    @Override
    public E getFront() {
        return null;
    }
}
