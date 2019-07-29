package com.jdk.data.structures.jdkdatastructures.wlimax;

/**
 * 栈类似于数组
 * 但是添加获取只能从一端操作
 */
public class LiStack<E> implements Stack<E>
{
    LiArrayList<E> array;

    public LiStack(int s){
        //Objec是任意类的父类
        //将任意类 强制类型转换 转换成 E类型  E代表未知
        array =  new LiArrayList<>(s);
    }
    //初始值为数组大小为10
    public LiStack(){ array = new LiArrayList<>(); }
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public E pop() {
        return array.removeList();
    }

    @Override
    public void push(E e) {
        array.addList(e);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append("[");
        for (int i=0;i<array.getSize();i++){
            res.append(array.get(i));
            if(i != array.getSize() -1) res.append(", ");
        }
        res.append("] TOP");
        return res.toString();
    }
}
