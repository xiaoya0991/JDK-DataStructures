package com.jdk.data.structures.jdkdatastructures.shengjie.arrayList.stack;

import com.jdk.data.structures.jdkdatastructures.shengjie.linkedList.stack.LinkedListStack;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayStackDemo<Integer> stack = new ArrayStackDemo<>(10);

        for (int i = 0; i < 5; i ++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);

        System.out.println("------------------------------------");

        int count = 10000000;
        ArrayStackDemo<Integer> arrayStack = new ArrayStackDemo<>();
        double time1 = testStack(arrayStack,count);
        System.out.println("ArrayStackDemo, time: "+ time1 + " s");
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time2 = testStack(linkedListStack,count);
        System.out.println("LinkedListStack, time: "+ time1 + " s");

    }

    /**
     * compare ArrayListStack with LinkedListStack
     * @param count
     * @return
     */
    private static double testStack(StackDemo<Integer> stack, int count){
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < count; i ++)
            stack.push(random.nextInt(Integer.MAX_VALUE));

        for (int i = 0; i < count; i ++)
            stack.pop();

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }
}
