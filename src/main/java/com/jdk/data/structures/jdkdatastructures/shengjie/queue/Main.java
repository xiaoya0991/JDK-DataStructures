package com.jdk.data.structures.jdkdatastructures.shengjie.queue;

import com.jdk.data.structures.jdkdatastructures.shengjie.linkedList.LinkedListQueue;

import java.util.Random;

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

        System.out.println("===================");

        int count = 100000;

        ArrayQueueDemo<Integer> arrayQueueDemo = new ArrayQueueDemo<>();
        double time1 = testQueue(arrayQueueDemo,count);
        System.out.println("ArrayQueue, time:" + time1 + "s");

        LoopQueueDemo<Integer> loopQueueDemo = new LoopQueueDemo<>();
        double time2 = testQueue(loopQueueDemo, count);
        System.out.println("LoopQueue, time:" + time2 + "s");

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        double time3 = testQueue(linkedListQueue, count);
        System.out.println("LinkedListQueue, time:" + time3 +"s");
    }

    private static double testQueue(QueueDemo<Integer> q, int count){
        long startTime = System.nanoTime();

        Random random = new Random();
        for(int i = 0; i < count; i ++)
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        for(int i = 0; i < count; i ++)
            q.dequeue();

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }
}
