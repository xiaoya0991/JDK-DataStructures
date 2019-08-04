package com.jdk.data.structures.jdkdatastructures.yining.linklist;

/**
 * 链表测试类
 *
 * @author: huyining
 * @since :    2019-08-02
 */
public class TestLinkedList {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.add(i, i);
        }

        System.out.println(linkedList.toString());

//        System.out.println(linkedList.getLinkedListSize());
//        // 反转链表
//        linkedList.reversetList(linkedList.getFirstNode());

        System.out.println(linkedList.toString());
    }
}
