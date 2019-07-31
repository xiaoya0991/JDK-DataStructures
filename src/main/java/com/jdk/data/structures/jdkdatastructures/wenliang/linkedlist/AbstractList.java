package com.jdk.data.structures.jdkdatastructures.wenliang.linkedlist;

/***
 * 集合抽象类
 * @author wenliang
 * @param <E>
 */
public abstract  class AbstractList <E> implements List<E> {


    /**
     * 元素的数量
     */
    protected int size;


    @Override
    public int size(){
        return size;
    }



    @Override
    public boolean isEmpty(){
        return size == 0;
    }


    @Override
    public void add(E element){
        add(size, element);
    }


    @Override
    public boolean contains(E element){
        return indexOf(element) != ELEMENT_NOT_FOUND;

    }


}
