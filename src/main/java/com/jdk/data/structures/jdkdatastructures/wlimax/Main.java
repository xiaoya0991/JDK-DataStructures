package com.jdk.data.structures.jdkdatastructures.wlimax;

public class Main {

    public static void main(String[] args) {
        int[] arre = new int[10];
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
}
