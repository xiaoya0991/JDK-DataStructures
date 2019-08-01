package com.jdk.data.structures.jdkdatastructures.shengjie.array;

public class Main {
    public static void main(String[] args) {
        ArrayDemo<Integer> arr = new ArrayDemo(20);
        arr.addFirst(5);
        for(int i = 0; i < 18; i ++){
            arr.addLast(i);
        }

        System.out.println(arr.get(1));

        arr.add(3,2);
        System.out.println(arr.get(0));

        arr.remove(1);
        System.out.println(arr.find(4));
    }
}
