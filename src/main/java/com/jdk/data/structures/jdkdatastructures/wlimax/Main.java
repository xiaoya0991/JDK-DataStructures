package com.jdk.data.structures.jdkdatastructures.wlimax;


import com.jdk.data.structures.jdkdatastructures.wlimax.tree.BSTree;

public class Main {

    public static void main(String[] args) {
        BSTree<Integer> bst = new BSTree<>();
        int[] nums = {5,3,6,8,4,2};
        for (int num:nums)
            bst.add(num);

        bst.indOrderNR();
        System.out.println("======");
        bst.indOrderNP();
//        System.out.println(bst);
    }
    private void liArrayTest(){
        LiArrayList arr = new LiArrayList(10);
        for(int i= 0;i<20;i++){
            arr.addList(i);
        }
        arr.removeElement(2);
        arr.removeList();
        arr.removeList();
        arr.removeList();
        arr.removeList();
        arr.removeList();
        arr.removeList();
        arr.removeList();
        arr.removeList();
        arr.removeList();
        System.out.println(arr);
    }

    private void LiStack(){
        LiStack stack = new LiStack<>();
        for(int i=1 ;i<5;i++){
            stack.push(i);
        }
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
    }
}
