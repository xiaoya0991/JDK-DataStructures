package com.jdk.data.structures.jdkdatastructures.wlimax;



public class Main {

    public static void main(String[] args) {
        LinkList arr = new LinkList();
//        arr.addFirse(1);
//        arr.addFirse(2);
        arr.addFirse(1);
        arr.addFirse(2);
        arr.addFirse(3);
        arr.addFirse(4);
        arr.addFirse(5);
        arr.addLast(6);
        System.out.println(arr);
        System.out.println(arr.get(4));

    }
    private void liArrayTest(){
        LiArrayList arr = new LiArrayList(10);
        for(int i= 0;i<20;i++){
            arr.addList(i);
        }
        arr.removeElement(2);
        arr.removeList();
        arr.removeList();
        arr.removeList();
        arr.removeList();
        arr.removeList();
        arr.removeList();
        arr.removeList();
        arr.removeList();
        arr.removeList();
        System.out.println(arr);
    }

    private void LiStack(){
        LiStack stack = new LiStack<>();
        for(int i=1 ;i<5;i++){
            stack.push(i);
        }
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
    }
}
