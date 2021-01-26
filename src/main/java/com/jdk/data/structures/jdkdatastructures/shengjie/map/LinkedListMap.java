package com.jdk.data.structures.jdkdatastructures.shengjie.map;

public abstract class LinkedListMap<K,V> implements Map<K,V> {
    private class Node{
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key){
            this(key, null, null);
        }

        public Node(){
            this(null,null,null);
        }

        @Override
        public String toString(){
            return key.toString() + " : " +value.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap(){
        dummyHead = new Node();
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private Node getNode(K key){
        Node current = dummyHead.next;
        while (current != null){
            if(current.key.equals(key))
                return current;
            current = current.next;
        }
        return null;
    }
    
    @Override
    public boolean containsKey(K key) {
        return getNode(key) != null;
    }

    public V getValue(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    public void setValue(K key, V newValue) {
        Node node = getNode(key);
        if(node == null)
            throw new IllegalArgumentException(key + "don't exist!!!");
        node.value = newValue;
    }

    @Override
    public V put(K key, V value){
        Node node = getNode(key);
        if(node == null){
            dummyHead.next = new Node(key,value,dummyHead.next);
            size ++;
        }else
            node.value = value;

        return node.value;
    }

    @Override
    public V remove(K key) {
        Node prev = dummyHead;
        while (prev.next != null){
            if(prev.next.key.equals(key))
                break;
            prev = prev.next;
        }

        if(prev.next != null){
            Node del = prev.next;
            prev.next = del.next;
            del.next = null;
            size --;
            return del.value;
        }

        return null;
    }
}
