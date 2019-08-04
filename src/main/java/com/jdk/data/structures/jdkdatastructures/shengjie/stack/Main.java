package com.jdk.data.structures.jdkdatastructures.shengjie.stack;

public class Main {
    public static void main(String[] args) {
        ArrayStackDemo<Integer> stack = new ArrayStackDemo<>(10);

        for (int i = 0; i < 5; i ++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
