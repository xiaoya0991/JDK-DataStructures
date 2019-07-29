package com.jdk.data.structures.jdkdatastructures.shengjie.array;

/**
 * 数组底层自己封装
 * @author shengjie
 */
public class ArrayDemo<E> {
    /**
     * 数组
     */
    private int[] data;
    /**
     * 数组大小
     */
    private int size;

    /**
     * 含参数的构造
     * @param capacity 数组容量
     */
    public ArrayDemo(int capacity){
        this.data = new int[capacity];
        this.size = 0;
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
        return this.size;
    }

    /**
     * 获取容量
     * @return
     */
    public int getCapacity(){
        return this.data.length;
    }

    /**
     * 数组为空处理
     * @return
     */
    public boolean isEmpty(){
        return this.size == 0;
    }

    /**
     * 添加数据元素
     * @param e 元素数据
     * @param index 元素位置
     */
    public void add(int e, int index){
        if(index < 0 && index > this.size)
            throw new IllegalArgumentException("添加数据元素位置不合法，应该在0～size质检");

        if(size == this.data.length)
            throw new IllegalArgumentException("数据已盛满，不能再添加了");

        //插入数据数据，插入位置以后的数据依次向后挪动一位
        for(int i = this.size-1;i >= index;i--){
            this.data[i-1] = this.data[i];
        }

        this.data[index] = e;
        this.size ++;
    }

    /**
     * 数组添加最后一个数据
     * @param e
     */
    public void addLast(int e){
        add(e,size);
    }

    /**
     * 数组添加第一个数据
     * @param e
     */
    public void addFirst(int e){
        add(e,0);
    }

}
