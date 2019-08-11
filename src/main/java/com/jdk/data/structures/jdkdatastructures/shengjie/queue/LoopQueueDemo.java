package com.jdk.data.structures.jdkdatastructures.shengjie.queue;

/**
 * write a loop queue
 * @param <E>
 */
public class LoopQueueDemo<E> implements QueueDemo<E>{
    /**
     * define a arrayList
     */
    private E[] data;
    /**
     * the front position of queue
     */
    private int front;
    /**
     * the tail position of queue
     */
    private int tail;
    /**
     * the size of the queue
     */
    private int size;

    /**
     * construction with parameters
     * @param capacity
     */
    public LoopQueueDemo(int capacity){
        this.data = (E[]) new Object[capacity + 1];//need more a length
        this.front = 0;
        this.tail = 0;
        this.size = 0;
    }

    /**
     * construction without parameters
     */
    public LoopQueueDemo(){ this(10); }

    /**
     * get the capacity of the queue
     * @return
     */
    public int getCapacity(){
        return this.data.length - 1;
    }

    /**
     * get the size of queue
     * @return
     */
    @Override
    public int getSize() {
        return this.size;
    }

    /**
     * empty handle
     * @return
     */
    @Override
    public boolean isEmpty() {
        return this.front == this.tail;
    }

    /**
     * enter the queue
     * @param e
     */
    @Override
    public void enqueue(E e) {
        if((this.tail + 1) % this.data.length == this.front)
            resize(getCapacity() * 2);

        this.data[tail] = e;
        tail = (tail + 1) % data.length;
        this.size ++;
    }

    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity + 1];
        for(int i = 0; i < this.size; i ++)
            newData[i] = this.data[(i + this.front) % this.data.length];

        this.data = newData;
        this.front = 0;
        tail = size;
    }

    /**
     * out of the queue
     * @return
     */
    @Override
    public E dequeue() {
        if(isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        E result = this.data[front];
        this.data[front] = null;
        this.front = (front + 1) % this.data.length;
        this.size --;
        //reduce the capacity
        if(this.size == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);

        return result;
    }

    /**
     * get the front of the queue
     * @return
     */
    @Override
    public E getFront() {
        if(isEmpty())
            throw new IllegalArgumentException("queue is empty");
        return this.data[this.front];
    }

    /**
     * override method of toString
     * @return
     */
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(String.format("queue: size = %d, capacity = %d\n",getCapacity(),data));
        stringBuilder.append("front [");
        for (int i = this.front; i != this.tail; i = (i + 1) % this.data.length){
            stringBuilder.append(data[i]);
            if((i + 1) % this.data.length != this.tail)
                stringBuilder.append(",");
        }
        stringBuilder.append("] tail");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LoopQueueDemo<Integer> queue = new LoopQueueDemo<>(10);
        for(int i = 0; i < 10; i ++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
