package com.jdk.data.structures.jdkdatastructures.shengjie.list;

/**
 * Array underlying package
 * time complexity:
 * add--O(n)
 * delete--O(n)
 * update--known:O(1);unknown:O(n)
 * find--known:O(1);unknown:O(n)
 * @author shengjie
 */
public class ArrayList<E> extends AbstractList<E>{
    /**
     * define an arrayList
     */
    private E[] data;
    /**
     * size of arrayList
     */
    private int size;
    /**
     * the constant of capacity
     */
    private static final int DEFAULT_CAPACITY = 10;

    private static final int ELEMENT_NOT_FOUND = -1;

    /**
     * Construction with parameters
     * @param capacity 数组容量
     */
    public ArrayList(int capacity){
        capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
        this.data = (E[]) new Object[capacity];
    }

    /**
     * construction without parameters
     */
    public ArrayList(){
        this(DEFAULT_CAPACITY);
    }

    /**
     * clear the array （guarantee the result is right just）
     */
    @Override
    public void clear(){
        size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    /**
     * get the capacity
     * @return the capacity value
     */
    public int getCapacity(){
        return this.data.length;
    }

    /**
     * empty handle
     * @return
     */
    @Override
    public boolean isEmpty(){
        return this.size == 0;
    }

    /**
     * add an element
     * @param e an element value
     * @param index index
     */
    @Override
    public void add(int index, E e){
        rangeCheckForAdd(index);

        if(size == this.data.length)
            resize(data.length << 1);

        //插入数据数据，插入位置以后的数据依次向后挪动一位
        for(int i = this.size-1;i >= index;i--){
            this.data[i+1] = this.data[i];
        }

        this.data[index] = e;
        this.size ++;
    }

    /**
     * expand automatic
     * @param newCapacity new capacity
     */
    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];
        for(int i = 0; i < size; i++)
            newData[i] = data[i];
        data = newData;
    }

    /**
     * add the last element
     * @param e an element value
     */
    public void addLast(E e){
        add(size, e);
    }

    /**
     * add the first element
     * @param e an element value
     */
    public void addFirst(E e){
        add(0, e);
    }

    /**
     * get an element
     * @param index index
     * @return an element value
     */
    @Override
    public E get(int index){
        rangeCheck(index);

        return data[index];
    }

    /**
     * get last element of arrayList
     * @return
     */
    public E getLast(){
        return get(size - 1);
    }

    /**
     * get first element of arrayList
     * @return
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * set an element
     * @param index index
     * @param e an element value
     * @return old element
     */
    @Override
    public E set(int index, E e){
        rangeCheck(index);

        E old = data[index];
        data[index] = e;
        return old;
    }

    /**
     * if contains an element
     * @param e an element value
     * @return boolean value
     */
    @Override
    public boolean contains(E e){
        for(int i = 0; i < size; i ++){
            if(data[i] == e)
                return true;
        }
        return false;
    }

    @Override
    public void add(E element) {
        add(size, element);
    }

    /**
     * get the position of this element
     * @param e an element value
     * @return the index of the element
     */
    @Override
    public int find(E e){
        if(e == null){
            for (int i = 0; i < size; i ++){
                if(data[i] == null) return i;
            }
        }else {
            for (int i = 0; i < size; i ++){
                if(e.equals(data[i])) return i;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * find the values of elements are e
     * @param e
     * @return
     */
    public ArrayList<E> findAll(E e){
        ArrayList<E> results = new ArrayList<>(size);
        if(e == null){
            for(int i = 0; i < size; i ++){
                if(data[i] == null)
                    results.add(i, null);
            }
        }else {
            for (int i = 0; i < size; i++) {
                if (e.equals(data[i]))
                    results.add(i, e);
            }
        }
        return results;
    }

    /**
     * remove an element at a location
     * @param index index
     * @return removed element value
     */
    @Override
    public E remove(int index){
        rangeCheck(index);

        Object result = data[index];

        for(int i = index+1; i < size; i++){
            data[i-1] = data[i];
        }
        size --;//defend size

        data[size] = null;//loitering objects != memory leak

        if(size == data.length / 2 && data.length / 2 != 0)//prevent shake of data
            resize(data.length >> 1);

        return (E) result;
    }

    /**
     * remove the first element
     * @return removed element value
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * remove the last element
     * @return removed element value
     */
    public E removeLast(){
        return remove(size - 1);
    }

    /**
     * remove this element,return index,or else return -1
     * @param e element value
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

    /**
     * override method of toString
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
        return stringBuilder.toString();
    }

}
