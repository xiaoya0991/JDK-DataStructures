package com.jdk.data.structures.jdkdatastructures.shengjie.list;

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

    protected void outOfBound(int index){
        throw new IndexOutOfBoundsException("index: " + index + ", size: " + size);
    }

    protected void rangeCheck(int index){
        if(index < 0 || index >= size){
            outOfBound(index);
        }
    }

    protected void rangeCheckForAdd(int index){
        if(index < 0 || index > size){
            outOfBound(index);
        }
    }
}
