package com.jdk.data.structures.jdkdatastructures.shengjie.list;

/**
 * 单向循环列表
 * @param <E>
 */
public class SingleCircleLinkedList<E> extends AbstractList<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
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

    public Node first;
    transient int size = 0;

    public SingleCircleLinkedList(){

    }

    public SingleCircleLinkedList(Node node, int size){
        this.first = node;
        this.size = size;
    }

    public void setSize(int size){
        this.size = size;
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

        Node current = first;
        for(int i = 0; i < index; i ++)
            current = current.next;
        return current.e;
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);

        Node current = first;
        for(int i = 0; i < index; i ++)
            current = current.next;

        current.e = element;

        return get(index);
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);

        if(index == 0){
            Node newFirst = new Node(element, first);
            Node last = (size == 0) ? newFirst : node(size - 1);
            last.next = newFirst;
            first = newFirst;
        }else {
            Node prev = node(index - 1);
            prev.next = new Node(element, prev.next);
        }

        size ++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);

        Node node = first;
        if(index == 0){
            if(size == 1) {
                first = null;
            }else {
                Node last = node(size - 1);//改变first前，要先拿到最后一个哦
                first = first.next;
                last.next = first;
            }
        }else {
            Node prev = node(index - 1);
            node = prev.next;
            prev.next = node.next;
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


    private Node node(int index){
        rangeCheck(index);

        Node current = first;
        for(int i = 0 ;i < index; i ++){
            current = current.next;
        }
        return current;
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
