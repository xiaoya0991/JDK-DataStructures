package com.jdk.data.structures.jdkdatastructures.shengjie.map;

public interface Map<K,V> {
    void add(K key, V value);

    V remove(K key);

    boolean contains(K key);

    V getValue(K key);

    void setValue(K key, V newValue);

    int getSize();

    boolean isEmpty();
}
