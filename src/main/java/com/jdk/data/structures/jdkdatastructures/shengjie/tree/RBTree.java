package com.jdk.data.structures.jdkdatastructures.shengjie.tree;

public class RBTree<K,V> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node{
        public K key;
        public V value;
        public Node right,left;
        public boolean color;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            left = right = null;
            color = RED;
        }
    }

    private Node root;
    private int size;

    public RBTree(){
        this.root = null;
        this.size = 0;
    }
}
