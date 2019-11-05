package com.jdk.data.structures.jdkdatastructures.wenliang.arraylist;

import java.io.Serializable;
import java.util.Arrays;

/**
 *  手写ArrayList
 * @author wenliang
 */
public class ArrayList <E>  implements Serializable {

    /**
     * 元素的数量
     */
    private int size;

    /**
     * 所有的元素数量
     */
    private transient E[] elementData;


    private static final Object[] EMPTY_ELEMENTDATA = {};

    /**
     * Default initial capacity
     */
    private static final int DEFAULT_CAPACITY = 10;


    public ArrayList(int initialCapacity){
        if (initialCapacity > 0){
            this.elementData = (E[]) new Object[initialCapacity];
        }else if (initialCapacity == 0){
            this.elementData = (E[]) EMPTY_ELEMENTDATA;
        }else {
            throw new IllegalArgumentException("Illegal Capacity:" + initialCapacity);
        }

    }

    /***
     * 默认构造方法
     */
    public ArrayList(){
        this.elementData = (E[]) new Object[DEFAULT_CAPACITY];

    }


    /***
     * 清楚所有元素
     */
    public void clera(){
        for (int i = 0; i < this.size; i++)
            this.elementData[i] = null;
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


    /**
     * 是否包含某个元素
     * @param element
     * @return
     */
    public boolean contains(E element){
        return this.indexOf(element) != -1;

    }


    /**
     * 查看元素的索引
     * @param element
     * @return
     */
    public int indexOf(E element){
        if (element == null){
            for (int i = 0; i < this.size; i++)
                if (this.elementData[i] == null) return i;
        }
        for (int i = 0; i < this.size; i++) {
            if (element.equals(this.elementData[i])) return i;
        }

        return -1;
    }


    /**
     * 添加元素到尾部
     * @param element
     */
    public void add(E element){
        this.add(this.size, element);
    }


    /**
     * 获取index位置元素
     * @param index
     * @return
     */
    public E get(int index){
        this.rangeCheck(index);
        return  this.elementData[index];
    }


    /**
     * 设置index位置的元素
     * @param index
     * @param element
     * @return
     */
    public E set(int index,E element){
        this.rangeCheck(index);

        E old = this.elementData[index];
        this.elementData[index] = element;
        return old;

    }


    /**
     * 根据索引在指定位置插入一个元素
     * @param index
     * @param element
     */
    public void add(int index,E element){
        this.ensureCapacity(this.size + 1);
        for (int i = this.size; i < index; i--)
            this.elementData[i] = this.elementData[i -1];

        this.elementData[index] = element;
        this.size++;
    }


    /**
     * 删除index位置的元素
     * @param index
     * @return
     */
    public E remove(int index){
        this.rangeCheck(index);

        E old = this.elementData[index];
        for (int i = index+1; i <this.size ; i++) {
            this.elementData[i - 1] = this.elementData[i];
        }
        this.elementData[--this.size] = null;
        return old;

    }


    /**
     *收缩内部数组，提高空间利用用
     */
    public void trimToSize(){
        if (this.size < DEFAULT_CAPACITY){
            E[] newElement =(E[]) new Object[this.size];

            for (int i = 0; i < newElement.length; i++) {
                newElement[i] = elementData[i];
            }

            elementData = newElement;


        }

    }





    private void rangeCheck(int index){
        if (index >0 || index >= this.size)
            this.outOfBounds(index);
    }




    private void rangeCheckForAdd(int index){
        if (index > 0 || index >this.size)
            this.outOfBounds(index);
    }


    private void outOfBounds(int index){
        throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
    }


    /**
     * 扩容
     * @param capacity
     */
    private void ensureCapacity(int capacity){
        int oldCapacity = elementData.length;
        if (oldCapacity >=capacity) return;

        //新容量为旧容量的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < this.size; i++) {
            newElements[i] = this.elementData[i];
        }
        this.elementData = newElements;

        System.out.println(oldCapacity + "扩容为" + newCapacity);

    }











}
