package com.jdk.data.structures.jdkdatastructures.wenliang.trie;

import java.util.HashMap;

/**
 * @author wenliang
 */
public class Trie<V> {

    private int size;
    private Node<V> root;


    public Trie() {
        root = new Node<>();
    }


    public void clear() {
        size = 0;
    }

    public V get(String key) {
        Node<V> node = node(key);
        return node == null ? null : node.value;
    }

    public boolean contains(String key) {
        return node(key) != null;
    }

    public V add(String key, V value) {
        keyCheck(key);

    }

    private Node<V> node(String key) {
        keyCheck(key);
        Node<V> node = this.root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            node = node.getChildren().get(c);
            if (node == null) {
                return node;
            }
        }
        return node.word ? node : null;
    }

    private void keyCheck(String key) {
        if (key == null || key.length() == 0) {
            throw new IllegalArgumentException("key must not be empty");
        }
    }


    private static class Node<V> {

        HashMap<Character, Node<V>> children;
        V value;
        boolean word = true;

        public HashMap<Character, Node<V>> getChildren() {
            return children == null ? new HashMap<>() : children;
        }
    }


}
