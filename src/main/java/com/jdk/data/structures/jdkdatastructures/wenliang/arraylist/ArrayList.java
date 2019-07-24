package com.jdk.data.structures.jdkdatastructures.wenliang.arraylist;

/**
 *  手写ArrayList
 * @author wenliang
 */
public class ArrayList <E> {

    /**
     * 元素的数量
     */
    private int size;

    /**
     * 所有的元素数量
     */
    private E[] datas;

    /**
     * 初始化容量
     */
    private static final int DEFAULT_CAPACITY = 10;


    public ArrayList(int capaticy){
        capaticy = (capaticy < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capaticy;
        this.datas = (E[]) new Object[capaticy];
    }

    /***
     * 默认构造方法
     */
    public ArrayList(){
        this(DEFAULT_CAPACITY);

    }


    /***
     * 清楚所有元素
     */
    public void clera(){
        for (int i = 0; i < this.size; i++)
            this.datas[i] = null;
        this.size = 0;
    }


    /**
     * 元素的数量
     * @return
     */
    public int size(){
        return this.size;

    }


    /***
     * 判断是否为空
     * @return
     */
    public boolean isEmpty(){
        return this.size == 0;

    }








}
