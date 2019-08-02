package com.jdk.data.structures.jdkdatastructures.wenliang.linkedlist;

import java.util.Collections;

/**
 * Doubly-linked list implementation of the {@code List} and {@code Deque}
 * interfaces.  Implements all optional list operations, and permits all
 * elements (including {@code null}).
 *
 * <p>All of the operations perform as could be expected for a doubly-linked
 * list.  Operations that index into the list will traverse the list from
 * the beginning or the end, whichever is closer to the specified index.
 *
 * <p><strong>Note that this implementation is not synchronized.</strong>
 * If multiple threads access a linked list concurrently, and at least
 * one of the threads modifies the list structurally, it <i>must</i> be
 * synchronized externally.  (A structural modification is any operation
 * that adds or deletes one or more elements; merely setting the value of
 * an element is not a structural modification.)  This is typically
 * accomplished by synchronizing on some object that naturally
 * encapsulates the list.
 *
 * If no such object exists, the list should be "wrapped" using the
 * {@link Collections#synchronizedList Collections.synchronizedList}
 * method.  This is best done at creation time, to prevent accidental
 * unsynchronized access to the list:<pre>
 *   List list = Collections.synchronizedList(new LinkedList(...));</pre>
 *
 * <p>The iterators returned by this class's {@code iterator} and
 * {@code listIterator} methods are <i>fail-fast</i>: if the list is
 * structurally modified at any time after the iterator is created, in
 * any way except through the Iterator's own {@code remove} or
 * {@code add} methods, the iterator will throw a {@link
 *  , in the face of concurrent
 * modification, the iterator fails quickly and cleanly, rather than
 * risking arbitrary, non-deterministic behavior at an undetermined
 * time in the future.
 *
 * <p>Note that the fail-fast behavior of an iterator cannot be guaranteed
 * as it is, generally speaking, impossible to make any hard guarantees in the
 * presence of unsynchronized concurrent modification.  Fail-fast iterators
 * throw {@code ConcurrentModificationException} on a best-effort basis.
 * Therefore, it would be wrong to write a program that depended on this
 * exception for its correctness:   <i>the fail-fast behavior of iterators
 * should be used only to detect bugs.</i>
 *
 * <p>This class is a member of the
 * <a href="{@docRoot}/../technotes/guides/collections/index.html">
 * Java Collections Framework</a>.
 *
 * @author  文亮 双向链表
 * @see     List
 * @see     ArrayList
 * @since 1.2
 * @param <E> the type of elements held in this collection
 */
public class LinkedList<E> extends AbstractList<E> {

     private  transient  Node<E> first;
     private  transient  Node<E> last;




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


    /**
     * links e as last element
     * @param e
     */
    void linkLast(E e){
        Node<E> l = this.last;
        Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }



    /**
     * Removes the element at the specified position in this list.  Shifts any
     * subsequent elements to the left (subtracts one from their indices).
     * Returns the element that was removed from the list.
     *
     *
     *
     */
    @Override
    public E remove(int index) {
        checkElementIndex(index);
        return unlink(node(index));
    }


    /**
     *
     * @param o
     * @return
     */
    public boolean remove(Object o){
        if (o == null){
            for (Node<E> x = first;x != null;x=x.next){
                if (x.element == null){
                    unlink(x);
                    return true;
                }
            }
        }else {
                for (Node<E> x =first;x !=null; x= x.next){
                    if (o.equals(x.element)){
                        unlink(x);
                        return true;
                    }
                }

        }
        return false;

    }



    /**
     * Removes and returns the first element from this list.
     *
     * @return the first element from this list
     *
     */
    public E removeFirst(){
        final Node<E> f = first;
        if (f == null)
            return null;
        return unlinkFirst(f);

    }


    /**
     *
     * @param f
     * @return
     */
    private E unlinkFirst(Node<E> f){
      final  E element = f.element;
        Node<E> next = f.next;
        f.element = null;
        f.next = null;

        first = next;
        if (next ==null)
            last = null;

        next.prev = null;
        size--;
        return element;

    }


    /**
     *
     * @param x
     * @return
     */
    E unlink(Node<E> x){
       final E element = x.element;
       final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev == null){
            first = next;

        }else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null){
            last = prev;

        }else {
            next.prev = prev;
            x.next = null;
        }

        x.element = null;
        size--;
        return element;
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



    private void checkElementIndex(int index){
        if (!isElementIndex(index)){
            return;
        }

    }



    /**
     * Tells if the argument is the index of an existing element.
     */
    private boolean isElementIndex(int index){
     return   index >= 0 && index < size;

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
}
