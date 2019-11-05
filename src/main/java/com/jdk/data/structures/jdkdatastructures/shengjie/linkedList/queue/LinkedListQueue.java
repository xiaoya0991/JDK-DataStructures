package com.jdk.data.structures.jdkdatastructures.shengjie.linkedList.queue;

import com.jdk.data.structures.jdkdatastructures.shengjie.arrayList.queue.QueueDemo;

/**
 * use LinkedList without dummyHead implements queue
 */
public class LinkedListQueue<E> implements QueueDemo<E> {
    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){ this(e, null); }

        public Node(){ this(null,null); }

        @Override
        public String toString(){ return e.toString(); }
    }

    private Node head,tail;
    private int size;

    public LinkedListQueue(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        if(tail == null){
            tail = new Node(e);
            head = tail;
        }else {
            tail.next = new Node(e);
            tail = tail.next;
        }

        size ++;
    }

    @Override
    public E dequeue() {
        if(isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        Node result = head;
        head = head.next;
        result.next = null;
        if(head == null)
            tail = null;
        size --;
        return result.e;
    }

    @Override
    public E getFront() {
        if(isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");

        return head.e;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LinkedListQueue: front: ");

        Node current = head;
        while(current != null){
            stringBuilder.append(current + "->");
            current = current.next;
        }
        stringBuilder.append("NULL tail");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for(int i =0; i < 6; i ++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
