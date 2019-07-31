package com.jdk.data.structures.jdkdatastructures.shengjie.array;

/**
 * 数组底层自己封装
 * @author shengjie
 */
public class ArrayDemo<E> {
    /**
     * 数组
     */
    private E[] data;
    /**
     * 数组大小
     */
    private int size;

    /**
     * 含参数的构造
     * @param capacity 数组容量
     */
    public ArrayDemo(int capacity){
        this.data = (E[]) new Object[capacity];
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
    public void add(E e, int index){
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
    public void addLast(E e){
        add(e,size);
    }

    /**
     * 数组添加第一个数据
     * @param e
     */
    public void addFirst(E e){
        add(e,0);
    }

    /**
     * 获取元素
     * @param index 索引
     * @return 元素值
     */
    public E get(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("传入的参数非法");
        return data[index];
    }

    /**
     * 设置元素
     * @param index 索引
     * @param e 元素值
     */
    public void set(int index, E e){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("传入的参数非法");
        data[index] = e;
    }

    /**
     * 是否包含该元素值
     * @param e 元素值
     * @return
     */
    public boolean contains(E e){
        for(int i = 0; i < size; i ++){
            if(data[i] == e)
                return true;
        }
        return false;
    }

    /**
     * 查找数组中元素e所在的索引，如果不存在就返回-1
     * @param e
     * @return
     */
    public int find(E e){
        for(int i = 0; i < size; i ++){
            if(data[i] == e)
                return i;
        }
        return -1;
    }

//    public int[] findAll(E e){
//        ArrayDemo<Integer> results = new ArrayDemo<>(size);
//        for(int i = 0; i < size; i ++){
//            if(data[i] == e){
//                results.add(i,e);
//            }
//        }
//    }

    /**
     * 删除某位置的元素
     * @param index 索引
     * @return 删除前，索引位置的数据
     */
    public E remove(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("传入的参数非法");

        Object result = data[index];

        for(int i = index+1; i < size; i++){
            data[index-1] = data[i];
        }
        size --;//维护size

        return (E) result;
    }

    /**
     * 删除第一个
     * @return 删除前，第一个的数据
     */
    public E removeFirst(){
        return data[0];
    }

    /**
     * 删除最后一个
     * @return 删除前，最后一个的数据
     */
    public E removeLast(){
        return data[size-1];
    }

    /**
     * 删除某元素，返回索引，如果不存在返回-1
     * @param e 元素值
     * @return
     */
    public boolean removeElement(E e){
        int index = find(e);
        if(index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

//    /**
//     * 删除所有该重复元素
//     * @param e
//     * @return
//     */
//    public boolean removeAllElement(E e){
//
//    }

    /**
     * 重写toString方法
     * @return
     */
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Array: size = %d, capacity = %d\n",size,data));
        stringBuilder.append("[");
        for (int i = 0; i < size; i ++){
            stringBuilder.append(data[i]);
            if(i != size-1)
                stringBuilder.append(",");
        }
        stringBuilder.append("]");
        return null;
    }

}
