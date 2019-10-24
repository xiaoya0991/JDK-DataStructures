package com.jdk.data.structures.jdkdatastructures.shengjie.linkedList.stack;

import com.jdk.data.structures.jdkdatastructures.shengjie.arrayList.stack.StackDemo;
import com.jdk.data.structures.jdkdatastructures.shengjie.linkedList.LinkedList;

/**
 * use LinkedList to implement stack
 * @param <E>
 */
public class LinkedListStack<E> implements StackDemo<E> {
    /**
     * define a LinkedList
     */
    private LinkedList<E> linkedList;

    /**
     * construction without parameter
     */
    public LinkedListStack(){
        linkedList = new LinkedList<>();
    }

    /**
     * get the size
     * @return
     */
    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    /**
     * empty handle
     * @return
     */
    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    /**
     * add an element
     * @param e
     */
    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    /**
     * remove an element
     * @return
     */
    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    /**
     * find an element
     * @return
     */
    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    /**
     * override toString method
     * @return
     */
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LinkedListStack: top ");
        stringBuilder.append(linkedList);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        for(int i = 0; i < 5; i ++){
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }
}
