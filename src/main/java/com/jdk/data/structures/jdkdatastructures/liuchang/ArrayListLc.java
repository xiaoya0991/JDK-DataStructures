package com.jdk.data.structures.jdkdatastructures.liuchang;

/**
 * @author: liuchang
 * @since :    2019-07-30
 */
public class ArrayListLc<E> {
    /**
     * 数量
     */
    private int size;

    /**
     * 存放数据
     */
    private E[] elementData;

    /**
     * 数组默认初始化容量
     */
    private static final int DEFAULT_CAPACITY = 10;


    public ArrayListLc(){
        this(DEFAULT_CAPACITY);
    }

    public ArrayListLc(int capacity){
        if(capacity <= 0){
            throw new IllegalArgumentException("初始化数量必须大于0");
        }
        this.elementData = (E[]) new Object[capacity];
        this.size = 0;
    }




    /**
     * 获取数组大小
     * @return
     */
    public int getSize(){
        return this.size;
    }


    /**
     * 添加元素
     * @param element
     * @return
     */
    public boolean add(E element){
        if(this.elementData.length == size){
            //数组扩容
            ensureCapacity();
        }
        this.elementData[size] = element;
        size ++;
        return true;
    }

    /**
     * 扩容数组
     */
    void ensureCapacity(){
        E[] newElementData = (E[]) new Object[this.elementData.length * 2];
        for(int i = 0; i < this.elementData.length; i++){
            newElementData[i] = elementData[i];
        }
        this.elementData = newElementData;
    }

    /**
     * 根据坐标位置获取元素
     * @param index
     * @return
     */
    public E get(int index){
        return elementData[index];
    }


}
