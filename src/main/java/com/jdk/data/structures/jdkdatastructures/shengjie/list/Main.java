package com.jdk.data.structures.jdkdatastructures.shengjie.list;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(6);
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
        System.out.println(arr.size());


        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i = 0; i < 5; i ++){
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(3,2);
        System.out.println(linkedList);

    }
}
