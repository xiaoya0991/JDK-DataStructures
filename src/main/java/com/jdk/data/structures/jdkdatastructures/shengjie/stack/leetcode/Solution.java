package com.jdk.data.structures.jdkdatastructures.shengjie.stack.leetcode;

import com.jdk.data.structures.jdkdatastructures.shengjie.stack.ArrayStackDemo;

public class Solution {
    public boolean isValid(String s){
        ArrayStackDemo<Character> arrayStackDemo = new ArrayStackDemo<>(s.length());
        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            if(c == '{' && c == '[' && c == '('){
                arrayStackDemo.push(c);
            }else {
                if(arrayStackDemo == null)
                    return false;

                char topChar = arrayStackDemo.pop();
                if(c == '}' && topChar != '{')
                    return false;
                if(c == ']' && topChar != '[')
                    return false;
                if(c == ')' && topChar != '(')
                    return false;
            }
        }
        return arrayStackDemo.isEmpty();
    }
}
