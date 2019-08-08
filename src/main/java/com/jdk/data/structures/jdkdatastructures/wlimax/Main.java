package com.jdk.data.structures.jdkdatastructures.wlimax;


import com.jdk.data.structures.jdkdatastructures.wlimax.tree.AVLTree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        AVLTree bstMap = new AVLTree();
        String filePath= "E:\\www\\fs2\\yield\\jianai.txt";
         File file =  new File(filePath);
         if(!file.exists()){ throw  new IllegalArgumentException("file is not null"); }
        try {
            BufferedReader in = new BufferedReader(new FileReader(filePath));
            String str;

            while ((str = in.readLine()) != null) {
                str = str.trim();
                for(String item:str.split(" ")){
                    if(bstMap.contains(item.trim())){
                        bstMap.set(item.trim(),(Integer) bstMap.get(item.trim()) + 1);
                    }else{
                        bstMap.add(item.trim(), 1);
                    }

                }
//                System.out.println(str.split(",")[4]);
//                bstMap.add(str.split(",")[3],str.split(",")[4]);
            }
//            System.out.println(bstMap.getSize());
            System.out.println(bstMap.get("The"));
//            System.out.println(bstMap.contains(1));
            System.out.println("end ===");
//            System.out.println(bstMap);
        } catch (IOException e) {
             System.out.println(e.getMessage());
        }

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
