package com.jdk.data.structures.jdkdatastructures.wenliang.map;

import java.util.Comparator;

public class TreeMpa<K,V> implements Map<K,V>{
    private static final boolean RED = false;
    private static final boolean BLACK= true;
    private Node<K,V> root;
    private int size;
    private Comparator<K> comparator;

    public TreeMpa(){
        this(null);
    }

    public TreeMpa(Comparator<K> comparator){
        this.comparator= comparator;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        this.root = null;
        this.size = 0;

    }

    @Override
    public V put(K key, V value) {
        keyNotNullCheck(key);

        //添加的第一个节点
        if (root == null) {
            root = new Node<>(key, value, null);
            this.size++;

            //添加节点之后的处理
            afterPut(root);
            return null;
        }

        //添加的不是第一个节点
        //找到父节点
        Node<K, V> parent = root;
        Node<K,V> node = root;
        int cmp = 0;
        while (node != null){
            cmp = compare(key, node.key);
            if (cmp > 0){
                node = node.right;
            }else if (cmp <0){
                node = node.left;
            }
            //相等,覆盖
            node.key = key;
            V oldValue = node.value;
            node.value = value;
            return oldValue;
        }

        //插入到父节点的那个位置
        Node<K, V> newNode = new Node<>(key, value, parent);
        if (cmp > 0){
            parent.right = newNode;
        }else {
            parent.left = newNode;
        }
        this.size++;
        afterPut(newNode);

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

    private void keyNotNullCheck(K key){
        if (key == null) {
            throw new IllegalArgumentException("key must not be null")
        }
    }

    private void afterPut(Node<K,V> node){

    }

    private int compare(K e1,K e2){
        if (this.comparator != null){
            return this.comparator.compare(e1, e2);
        }
        return ((Comparable<K>) e1).compareTo(e2);
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
