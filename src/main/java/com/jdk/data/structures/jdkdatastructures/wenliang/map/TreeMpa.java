package com.jdk.data.structures.jdkdatastructures.wenliang.map;

public class TreeMpa<K,V> implements Map<K,V>{
    private static final boolean RED = false;
    private static final boolean BLACK= true;


    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public V put(K key, V value) {
        return null;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        return false;
    }

    @Override
    public void traversal(Visitor<K, V> visitor) {

    }

    private static class Node<K,V> {
        K key;
        V value;
        boolean color = RED;
        Node<K,V> left;
        Node<K,V> right;
        Node<K,V> parent;
        public Node(K key,V value,Node<K,V> parent){
            this.key = key;
            this.value = value;
            this.parent = parent;
        }

        public boolean isLeft(){
            return left == null && right==null;
        }

        public boolean hasTwoChildren(){
            return left != null && right != null ;
        }

        public boolean isLeftChild(){
            return parent != null && this == parent.left;
        }






    }
}
