package com.jdk.data.structures.jdkdatastructures.wenliang.set;

import com.jdk.data.structures.jdkdatastructures.wenliang.linkedlist.LinkedList;
import com.jdk.data.structures.jdkdatastructures.wenliang.linkedlist.List;

/**
 * 链表实现Set集合
 *
 * @author wenliang
 */
public class ListSet<E>  implements Set<E>{

    private List<E> list = new LinkedList();


    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void clera() {
        this.list.clera();

    }

    /**
     *
     * @param element
     *
     * @return
     */
    @Override
    public boolean contains(E element) {
      return  list.contains(element);
    }


    @Override
    public void traversal(Visitor visitor) {
        if (visitor == null) return;

        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (visitor.visit(list.get(i))) return;

        }

    }

    /**
     *
     * @param element
     */
    @Override
    public void add(E element) {
        int index = list.indexOf(element);
        if (index != List.ELEMENT_NOT_FOUND){
            list.set(index, element);
        }
        list.add(element);
    }

    /**
     *
     * @param element
     */
    @Override
    public void remove(E element) {
        int index = list.indexOf(element);
        if (index != List.ELEMENT_NOT_FOUND){
            list.remove(index);
        }

    }
}
