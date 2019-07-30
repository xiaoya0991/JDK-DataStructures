package com.jdk.data.structures.jdkdatastructures.shengjie.array;

public class Main {
    public static void main(String[] args) {
        ArrayDemo<Integer> arr = new ArrayDemo(10);

        arr.add(-1,0);
        arr.add(0,1);
        arr.add(1,2);
        arr.add(2,3);
        arr.add(3,4);

        System.out.println(arr);
    }
}
