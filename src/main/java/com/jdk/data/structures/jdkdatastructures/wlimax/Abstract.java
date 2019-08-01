package com.jdk.data.structures.jdkdatastructures.wlimax;

public abstract class Abstract<E> implements Base<E> {

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
    public void addLast(E element){
        add(size, element);
    }
    public void addFirst(E element){ add(0, element); }


    @Override
    public boolean contains(E element){
        return size == 0;

    }
}
