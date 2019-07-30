package com.jdk.data.structures.jdkdatastructures.wenliang.linkedlist;

/**
 * 双向链表实现的LinkedList
 * @author wenliang
 */
public class LinkedList<E> extends AbstractList<E> {

    private Node first;
    private Node last;


    /***
     *
     * @param <E>
     */
    private static class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;

        public Node(Node prev,E element,Node next){
            this.prev = prev;
            this.element = element;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();

            if (prev != null) {
                sb.append(prev.element);
            } else {
                sb.append("null");
            }

            sb.append("_").append(element).append("_");

            if (next != null) {
                sb.append(next.element);
            } else {
                sb.append("null");
            }

            return sb.toString();
        }
    }

    @Override
    public void clera() {
        size = 0;
        this.first = null;
        this.last = null;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {
        if (index == this.size){
            Node oldLast = this.last;
            
        }

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(E element) {
        return 0;
    }
}
