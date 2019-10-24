package com.jdk.data.structures.jdkdatastructures.shengjie.linkedList;

/**
 * 集合 抽象类
 * @author holy
 */
public abstract class AbstractList<E> implements List<E> {
    /**
     * 元素个数
     */
    protected transient int size;

    @Override
    public int size(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public void clear(){
        size = 0;
    }

}
