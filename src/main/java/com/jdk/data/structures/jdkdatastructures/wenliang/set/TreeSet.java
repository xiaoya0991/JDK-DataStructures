package com.jdk.data.structures.jdkdatastructures.wenliang.set;

import com.jdk.data.structures.jdkdatastructures.wenliang.set.tree.BinaryTree;
import com.jdk.data.structures.jdkdatastructures.wenliang.set.tree.RBTree;

/**
 * @author wenliang
 */
public class TreeSet<E> implements Set<E> {

    private RBTree<E> tree = new RBTree<>();

    @Override
    public int size() {
        return tree.size();
    }

    @Override
    public boolean isEmpty() {
      return tree.isEmpty();
    }

    @Override
    public void clera() {
        this.tree.clear();
        return;
    }

    @Override
    public boolean contains(E element) {
        return tree.contains(element);
    }

    @Override
    public void traversal(Visitor<E> visitor) {
        this.tree.inorder(new BinaryTree.Visitor<E>() {
            @Override
            public boolean visit(E element) {
                return false;
            }
        });

    }

    @Override
    public void add(E element) {
        this.tree.add(element);
        return;
    }

    @Override
    public void remove(E element) {
        this.tree.remove(element);
        return;
    }
}
