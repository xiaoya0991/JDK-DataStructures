package com.jdk.data.structures.jdkdatastructures.shengjie.list;

/**
 * 双向循环列表
 * @param <E>
 */
public class CircleLinkedList<E> extends AbstractList<E> {

    private class Node<E>{
        public E e;
        public Node prev;
        public Node next;

        public Node(Node prev, E e, Node next){
            this.prev = prev;
            this.e = e;
            this.next = next;
        }

        @Override
        public String toString(){
            StringBuilder stringBuilder = new StringBuilder();
            if(e != null) stringBuilder.append(e);
            if(next.e != null) stringBuilder.append("_").append(next.e);
            return stringBuilder.toString();
        }
    }

    transient Node<E> first;
    transient Node<E> last;
    transient Node<E> current;
    transient int size = 0;

    @Override
    public void clear(){
        this.size = 0;
        this.first = null;
        this.last = null;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public boolean contains(E element) {
        Node current = first;

        while (current != null){
            if(current.e.equals(element)) return true;
            current = current.next;
        }

        return false;
    }

    @Override
    public void add(E element) {
        add(size, element);
    }

    @Override
    public E get(int index) {
        rangeCheck(index);

        Node<E> current = first;
        for(int i = 0; i < index; i ++)
            current = current.next;
        return current.e;
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);

        Node<E> current = first;
        for(int i = 0; i < index; i ++)
            current = current.next;

        current.e = element;

        return get(index);
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);

        if(index == size){
            Node<E> oldLast = last;
            last = new Node(oldLast,element, first);
            if(oldLast == null){//添加第一个元素
                first = last;
                first.prev = first;
                first.next = first;
            }else {
                oldLast.next = last;
                first.prev = last;
            }
        }else {
            Node<E> next = node(index);
            Node<E> prev = next.prev;
            Node<E> node = new Node<>(prev, element, next);
            next.prev = node;
            prev.next = node;

            if(next == first/*index == 0*/) {
                first = node;
            }
        }

        size ++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);

        return remove(node(index));
    }

    private E remove(Node<E> node){
        if(size == 1){
            first = null;
            last = null;
        }else {
            Node<E> prev = node.prev;
            Node<E> next = node.next;
            prev.next = next;
            next.prev = prev;

            if(node == first){
                first = next;
            }

            if(node == last){
                last = prev;
            }
        }

        size --;

        return node.e;
    }

    @Override
    public int find(E e){
        if(e == null){
            for (int i = 0; i < size; i ++){
                if(node(i) == null) return i;
            }
        }else {
            for (int i = 0; i < size; i ++){
                if(e.equals(node(i))) return i;
            }
        }
        return ELEMENT_NOT_FOUND;
    }


    private Node<E> node(int index){
        rangeCheck(index);

        Node current = first;
        for(int i = 0 ;i < index; i ++){
            current = current.next;
        }
        return current;
    }

    public void reset(){
        current = first;
    }

    public E next(){
        if(current == null) return null;
        current = current.next;
        return current.e;
    }

    public E remove(){
        if(current == null) return null;

        Node<E> node = current.next;
        E element = remove(current);
        if(size == 0){
            current = null;
        }else {
            current = node;
        }

        return element;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size:" + size + ","+ "[");
        for(int i = 0; i < size; i ++){
            stringBuilder.append("_" + node(i));
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
