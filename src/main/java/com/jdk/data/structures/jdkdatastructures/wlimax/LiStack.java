package com.jdk.data.structures.jdkdatastructures.wlimax;

/**
 * 栈类似于数组
 * 但是添加获取只能从一端操作
 */
public class LiStack<E>
{
    LiArrayList<E> array;

    public LiStack(int s){
        //Objec是任意类的父类
        //将任意类 强制类型转换 转换成 E类型  E代表未知
        this.array =  new LiArrayList<>(s);
    }
    //初始值为数组大小为10
    public LiStack(){ array = new LiArrayList<>(); }

    /**
     * 判断对象是否为空
     * @return
     */
    public boolean isEmpty() {
        return this.array.isEmpty();
    }

    /**
     * 从尾部取出元素
     * @return
     */
    public E peek() {
        return this.array.getLast();
    }

    /**
     * 从尾部删除元素
     * @return
     */
    public E pop() {
        return this.array.removeList();
    }

    /**
     * 向尾部添加元素
     * @param e
     */
    public void push(E e) {
        this.array.addList(e);
    }

    /**
     * 获取栈元素数
     * @return
     */
    public int getSize() {
        return this.array.getSize();
    }

    /**
     * 获取栈大小
     * @return
     */
    public int getCapacity(){
        return this.array.getCapacity();
    }

    /**
     * 重新toString方法
     * @return
     */
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append("[");
        for (int i=0;i<this.array.getSize();i++){
            res.append(this.array.get(i));
            if(i != this.array.getSize() -1) res.append(", ");
        }
        res.append("] TOP");
        return res.toString();
    }
}
