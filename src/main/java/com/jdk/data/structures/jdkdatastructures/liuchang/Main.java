package com.jdk.data.structures.jdkdatastructures.liuchang;

/**
 * @author liuchang
 */
public class Main {

    public static void main(String[] args) {
        ArrayListLc arrayListLc = new ArrayListLc<Integer>();
       for(int i = 0 ; i < 15; i++){
           arrayListLc.add(i);
           System.out.println("size==" + arrayListLc.getSize());
       }
        for(int i = 0 ; i < 15; i++){
            System.out.println("element==" + arrayListLc.get(i));
        }
    }
}
