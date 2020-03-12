package com.jdk.data.structures.jdkdatastructures.wenliang.map;


/**
 * @param <K>
 * @param <V>
 * @author wenliang
 */
public class LinkedHashMap<K, V> extends HashMap<K, V> {

    private LinkedNode<K, V> first;
    private LinkedNode<K, V> last;


    @Override
    protected Node<K, V> createNode(K key, V value, Node<K, V> parent) {
        LinkedNode<K, V> node = new LinkedNode<>(key, value, parent);
        if (first == null) {
            first = last = node;
        } else {
            last.next = node;
            node.prev = last;
            last = node;
        }
        return node;
    }


    @Override
    public void clear() {
        super.clear();
        first = null;
        last = null;
    }


    @Override
    public void traversal(Visitor<K, V> visitor) {
        if (visitor == null) {
            return;
        }
        LinkedNode<K, V> node = first;
        while (node != null) {
            if (visitor.visit(node.key, node.value)) {
                return;
            }
            node = node.next;
        }

    }


    private static class LinkedNode<K, V> extends Node<K, V> {

        LinkedNode<K, V> prev;
        LinkedNode<K, V> next;

        public LinkedNode(K key, V value, Node<K, V> parent) {
            super(key, value, parent);
        }
    }
}
