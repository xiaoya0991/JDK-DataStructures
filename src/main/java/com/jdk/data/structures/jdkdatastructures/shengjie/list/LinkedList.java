package com.jdk.data.structures.jdkdatastructures.shengjie.list;

public class LinkedList<E> extends AbstractList<E> {

    private static final int ELEMENT_NOT_FOUND = -1;

    private class Node<E>{

        public E e;
        public Node prev;
        public Node next;

        public Node(E e,Node prev, Node next){
            this.e = e;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString(){
            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append(prev != null ? prev.e : null);

            stringBuilder.append("_").append(e).append("_");

            stringBuilder.append(next != null ? next.e : null);

            return e.toString();
        }
    }


    /**
     * define the only dummy head node
     */
    transient Node<E> first;
    transient Node<E> last;

    /**
     * define size of LinkedList
     */
    transient int size;

    @Override
    public void clear(){
        first = last = null;
        size = 0;
    }

    /**
     * get the size
     * @return
     */
    @Override
    public int size(){return this.size; }

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

    /**
     * get the node of the current location
     * @param index
     * @return
     */
    private Node<E> node(int index){
        Node<E> current = first;
        for(int i = 0 ;i < index; i ++){
            current = current.next;
        }
        return current;
    }

    /**
     * add an element at a position
     * @param e
     * @param index
     */
    @Override
    public void add(int index, E e){
        rangeCheckForAdd(index);

        Node<E> prev = index == 0 ? first : node(index - 1);
        prev.next = new Node<E>(e,prev,prev.next);

        size ++;
    }

    /**
     * insert new element at the head node
     */
    public void addFirst(E e){ add(0, e); }

    /**
     * add an element
     * @param e
     */
    public void addLast(E e){ add(size, e); }

    /**
     * get an element at the position
     * @param index
     * @return
     */
    @Override
    public E get(int index){
        rangeCheck(index);

        Node<E> current = first;
        for(int i = 0; i < index; i ++)
            current = current.next;
        return current.e;
    }

    /**
     * get the first element
     * @return
     */
    public E getFirst(){

        return get(0); }

    /**
     * get the last element
     * @return
     */
    public E getLast(){ return get(size - 1); }

    /**
     * update the element at a position
     * @param index
     * @param e
     */
    @Override
    public E set(int index, E e){
        rangeCheck(index);

        Node current = first;
        for(int i = 0; i < index; i ++)
            current = current.next;

        current.e = e;

        return get(index);
    }

    /**
     * judge an element is existed
     * @param e
     * @return
     */
    @Override
    public boolean contains(E e){
        Node<E> current = first;
        while (current != null){
            if(current.e.equals(e))
                return true;
            current = current.next;
        }
        return false;
    }

    @Override
    public void add(E e) {
        add(size , e);
    }

    /**
     * remove an element at a position
     * @param index
     * @return
     */
    @Override
    public E remove(int index){
        rangeCheck(index);

        Node<E> node = node(index);
        Node<E> prev = node.prev;
        Node<E> next = node.next;

        if(prev == null){//index=0
            first = next;
        }else {
            prev.next = next;
        }

        if(next == null){
            last = prev;
        }else {
            next.prev = prev;
        }

        size --;

        return node.e;
    }

    /**
     * remove the first element
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * remove repeated element in LinkedList
     */
    public Node<E> removeSameElement(Node node,E e){

        if(node == null)
            return null;
        while (node.e == e){
            Node<E> delNode = first;
            node = delNode.next;
            delNode = null;
        }

        Node<E> prev = node;
        while(prev.next != null){
            if(prev.next.e == e){
                Node<E> delNode = prev;
                prev.next = node.next;
                delNode = null;
            }else
                prev = prev.next;
        }
        return node;

    }

    /**
     * remove an element
     * @param e
     */
    public void remove(E e){
        if(!contains(e))
            throw new IllegalArgumentException("the element is not existed!!!");

        first = removeSameElement(first,e);
    }

    /**
     * return a positive element of a node
     * @param index
     * @return
     */
    public E findPositiveNode(int index){
        rangeCheck(index);

        Node<E> current = first;
        for(int i = 0; i < index; i ++)
            current = current.next;
        return current.e;
    }

    /**
     * Return to the countdown to a node
     * @param index
     * @return
     */
    public E findCountdownNode(int index){
        rangeCheck(index);

        Node<E> current = first;
        for(int i = 0; i < size - index; i ++)
            current = current.next;
        return current.e;
    }

    /**
     * return the medium node
     * @return
     */
    public String getMediumNode(){
        if(size / 2 == 1)
            return get((size + 1) / 2).toString();
        else
            return get((size - 1) / 2).toString()+","+get((size + 1) / 2).toString();
    }

    /**
     * return the smallest head node from sorted LinkedList(ASC)
     * @return
     */
    public E getHeadFromSorted(){
        E e = null;
        for(int i = 0; i < size - 1; i ++) {
            if (get(i).toString().compareTo(get(i + 1).toString()) > 0)
                e = get(i + 1);
            else
                e = get(i);
        }
        return e;
    }

    /**
     * define two pointer
     */
    private Node slow,fast;

    /**
     * judge LinkedList has loop
     * @return
     */
    public boolean hasCircle(){

        slow = first;
        fast = first.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
                return true;
        }
        return false;
    }

    /**
     * remove the last element
     * @return
     */
    public E removeLast(){
        return remove(size - 1);
    }

    /**
     * 链表反转,leetcode24
     * @param head
     * @return
     */
    public Node<E> reverseList(Node head) {
        if(head == null && head.next == null) return head;

        Node<E> newHead = null;
        while (head != null) {
            Node<E> tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }

        return newHead;
    }

}
