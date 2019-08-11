package com.jdk.data.structures.jdkdatastructures.shengjie.arrayList;

public class Main {
    public static void main(String[] args) {
        ArrayDemo<Integer> arr = new ArrayDemo<>(6);
        arr.addFirst(5);
        for(int i = 0; i < 3; i ++) {
            arr.addLast(i);
        }

        System.out.println(arr);

        arr.add(3,2);
        System.out.println(arr);

        arr.add(111,2);
        System.out.println(arr);

        arr.remove(1);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);

        arr.removeLast();
        System.out.println(arr);

        System.out.println(arr.removeElement(1));
        System.out.println(arr.getSize());

    }
}
