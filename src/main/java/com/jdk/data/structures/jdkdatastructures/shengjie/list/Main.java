package com.jdk.data.structures.jdkdatastructures.shengjie.list;

public class Main {
    public static void main(String[] args) {
        testList(new SingleCircleLinkedList<>());
    }

    static void testList(List<Integer> list){
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.add(0,5);
        list.add(2,6);
        list.add(list.size() , 7);

        list.remove(0);
        list.remove(2);
        list.remove(list.size() - 1);

        System.out.println(list.find(4) == 3);
        System.out.println(list.find(2) == list.ELEMENT_NOT_FOUND);
        System.out.println(list.contains(3));
        System.out.println(list.get(0) == 1);
        System.out.println(list.get(1) == 6);
        System.out.println(list.get(list.size() - 1) == 4);
    }
}
