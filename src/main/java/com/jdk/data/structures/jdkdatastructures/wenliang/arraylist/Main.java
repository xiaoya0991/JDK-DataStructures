package com.jdk.data.structures.jdkdatastructures.wenliang.arraylist;

import com.jdk.data.structures.jdkdatastructures.wlimax.LiArrayList;

import java.util.ArrayList;
/**
 * @author wenliang
 */
public class Main {

    public static void main(String[] args) {


        int num = 100000000;
        long newtTime = System.currentTimeMillis();
        ArrayList<Integer> list = new ArrayList(num);
        for (int i = 0; i < num; i++) {
            list.remove(i);
        }
        System.out.println("文亮"+"耗时："+(System.currentTimeMillis() - newtTime+"毫秒"));


        ArrayList<Integer> list1 = new ArrayList(num);

        for (int i = 0; i < num; i++) {
            list1.add(i);
        }
        System.out.println("文亮"+"耗时："+(System.currentTimeMillis() - newtTime+"毫秒"));



    }
}
