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
                if (this.datas[i] == null) return i;
        }
        for (int i = 0; i < this.size; i++) {
            if (element.equals(this.datas[i])) return i;
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
        return  this.datas[index];
    }


    /**
     * 根据索引在指定位置插入一个元素
     * @param index
     * @param element
     */
    public void add(int index,E element){
        this.rangeCheckForAdd(index);
        for (int i = this.size; i < index; i--)
            this.datas[i] = this.datas[i -1];

        this.datas[index] = element;
        this.size++;
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












}
