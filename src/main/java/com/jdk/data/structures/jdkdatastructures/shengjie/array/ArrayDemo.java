package com.jdk.data.structures.jdkdatastructures.shengjie.array;

/**
 * 数组底层自己封装
 * @author shengjie
 */
public class ArrayDemo {
    /**
     * 数组
     */
    int[] data;
    /**
     * 数组大小
     */
    int size;

    /**
     * 含参数的构造
     * @param capacity 数组容量
     */
    public ArrayDemo(int capacity){
        data = new int[capacity];
        size = 0;
    }

    /**
     * 不含参数的构造，默认数组容量为10
     */
    public ArrayDemo(){
        this(10);
    }

    /**
     * 获取实际数组大小
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 获取容量
     * @return
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 数组为空处理
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

}
