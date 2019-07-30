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


    /***
     * 获取值
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        return this.node(index).element;
    }


    /***
     *
     * @param index
     * @param element
     * @return
     */
    @Override
    public E set(int index, E element) {
        Node<E> node = this.node(index);
        E old = node.element;
        node.element = element;
        return old;
    }


    /***
     * 添加元素
     * @param index
     * @param element
     */
    @Override
    public void add(int index, E element) {
        if (index == this.size){
            Node oldLast = this.last;
            last = new Node(oldLast, element, null);
            if (oldLast == null){
                this.first = last;

            }else {
                oldLast.next = last;
            }

        }else {
            Node<E> next = this.node(index);
            Node<E> prev = next.prev;
            Node<E> node = new Node<>(prev, element, next);
            next.prev = node;

            if (prev== null){
                this.first = node;

            }else {
                prev.next = node;
            }
        }
    }

    @Override
    public E remove(int index) {
        Node<E> node = this.node(index);
        Node<E> prev = node.prev;
        Node<E> next = node.next;

        if (prev == null){
            this.first = next;
        }else {
            prev.next = next;
        }

        if (next == null){
            this.last = prev;

        }else {
            next.prev = prev;
        }
        this.size--;
        return node.element;
    }


    /**
     *
     * @param element
     * @return
     */
    @Override
    public int indexOf(E element) {
        if (element == null){
            Node node = this.first;

            for (int i = 0; i < this.size; i++)
                if (node.element == null) return i;
                node = node.next;

        }else {
            Node node = this.first;
            for (int i = 0; i < this.size; i++)
                if (element.equals(node.element)) return i;
                node = node.next;

        }
        return ELEMENT_NOT_FOUND;

    }




    /***
     * 获取inde位置对应的对象
     * @param index
     * @return
     */
    private Node<E> node(int index){
        if (index < (this.size >> 1)){
            Node node = this.first;
            for (int i = 0; i < index; i++)
                node = node.next;
            return node;
        }
            Node node = this.last;
            for (int i=this.size -1;i>index;i--)
                node = node.prev;

            return node;
    }
}
