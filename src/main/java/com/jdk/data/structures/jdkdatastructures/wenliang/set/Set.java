package com.jdk.data.structures.jdkdatastructures.wenliang.set;

/**
 * Set集合接口
 *
 * @author wenliang
 */
public interface Set<E> {

    int size();

    boolean isEmpty();

    void clera();

    boolean contains(E element);

    void traversal(Visitor<E> visitor);

    void add(E element);

    void remove(E element);

    public static abstract class Visitor<E>{
        boolean stop;

       public abstract boolean visit(E element);
    }

}
