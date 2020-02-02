package com.jdk.data.structures.jdkdatastructures.wenliang.set;

import com.jdk.data.structures.jdkdatastructures.wenliang.set.Set.Visitor;

/**
 * @author wenliang
 */
public class Main {

    public static void main(String[] args) {

        Set<Integer> set = new ListSet<>();
        set.add(10);
        set.add(11);
        set.add(12);
        set.add(11);
        set.add(12);
        set.add(10);


        set.traversal(new Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                System.out.println(element);
                return false;
            }
        });


    }

}
