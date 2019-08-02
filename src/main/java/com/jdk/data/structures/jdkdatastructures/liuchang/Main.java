package com.jdk.data.structures.jdkdatastructures.liuchang;

import java.util.ArrayList;

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
        System.out.println("wwwwwsize==" + arrayListLc.getSize());

        arrayListLc.remove(6);
        System.out.println("wwwwwsize==" + arrayListLc.getSize());
    }
}
