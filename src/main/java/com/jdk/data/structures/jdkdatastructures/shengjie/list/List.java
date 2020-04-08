package com.jdk.data.structures.jdkdatastructures.shengjie.list;

/**
 * 集合 接口
 * @author holy
 */
public interface List<E> {
    /**
     * Removes all of the elements from this list.
     * The list will be empty after this call returns.
     */
    void clear();

    int size();

    boolean isEmpty();

    boolean contains(E element);

    void add(E element);

    E get(int index);

    E set(int index, E element);

    void add(int index, E element);

    E remove(int index);
}
