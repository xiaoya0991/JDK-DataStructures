package com.jdk.data.structures.jdkdatastructures.shengjie.queue;

/**
 * @author Holy
 */
public class Main {
    public static void main(String[] args) {
        ArrayQueueDemo<Integer> queue = new ArrayQueueDemo<>(10);
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
