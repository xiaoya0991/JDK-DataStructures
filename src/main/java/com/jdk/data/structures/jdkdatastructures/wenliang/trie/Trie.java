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

    public V remove(String key) {
        Node<V> node = node(key);
        if (node == null || !node.word) {
            return null;
        }
        size--;
        if (node.children != null && !node.children.isEmpty()) {
            V oldValue = node.value;
            node.word = false;
            node.value = null;
            return oldValue;
        }
        return null;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public void clear() {
        size = 0;
        root = null;
    }

    public V get(String key) {
        Node<V> node = node(key);
        return node == null ? null : node.value;
    }

    public boolean contains(String key) {
        return node(key) != null;
    }


    public boolean startsWith(String prefix) {
        keyCheck(prefix);
        Node<V> node = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            if (node == null || node.children == null) {
                return false;
            }
            char c = prefix.charAt(i);
        }
        return true;
    }

    public V add(String key, V value) {
        keyCheck(key);
        Node<V> node = this.root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            Node<V> childNode = node.getChildren().get(c);
            if (childNode == null) {
                childNode = new Node<>();
                node.getChildren().put(c, childNode);
            }
            node = childNode;
        }
        if (!node.word) {
            node.word = true;
            node.value = value;
            size++;
        }
        V oldValue = node.value;
        node.value = value;
        return oldValue;
    }

    private Node<V> node(String key) {
        keyCheck(key);
        Node<V> node = this.root;
        for (int i = 0; i < key.length(); i++) {
            if (node == null || node.children == null) {
                return null;
            }
            char c = key.charAt(i);
            node = node.getChildren().get(c);
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
