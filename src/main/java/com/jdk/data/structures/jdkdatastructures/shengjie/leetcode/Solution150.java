package com.jdk.data.structures.jdkdatastructures.shengjie.leetcode;

import java.util.Stack;

/**
 * 150. 逆波兰表达式求值
 * 根据逆波兰表示法，求表达式的值。
 *
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 * 说明：
 *
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * 示例 1：
 *
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: ((2 + 1) * 3) = 9
 * 示例 2：
 *
 * 输入: ["4", "13", "5", "/", "+"]
 * 输出: 6
 * 解释: (4 + (13 / 5)) = 6
 * 示例 3：
 *
 * 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * 输出: 22
 * 解释:
 *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution150 {
    /**
     * solution one:
     */
    //判断是不是符号
    private boolean isOperator(String token){
        return "+-*/".contains(token);
    }
    //计算
    private int caculate(Integer right, Integer left, String operator){//运算的前后数字位置很重要
        switch (operator){
            case "+" :
                return left + right;
            case "-" :
                return left - right;
            case "*" :
                return left * right;
            default:
                return left / right;
        }
    }
//    public int evalRPN(String[] tokens) {
//        Stack<Integer> stack = new Stack<>();
//        for (String token : tokens) {
//            if(isOperator(token)){
//                Integer right = stack.pop();
//                Integer left = stack.pop();
//                stack.push(caculate(right, left, token));
//            }else {
//                stack.push(Integer.parseInt(token));
//            }
//        }
//        return stack.pop();
//    }





    /**
     * solution two:
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            stack.push(isOperator(token) ? caculate(stack.pop(), stack.pop(), token) : stack.push(Integer.parseInt(token)));
        }
        return stack.pop();
    }





    /**
     * solution three:
     */
//    public int evalRPN(String[] tokens) {
//        Stack<Integer> stack = new Stack<>();
//        for (String token : tokens) {
//            switch (token){
//                case "+" :
//                    return stack.pop() + stack.pop();
//                case "*" :
//                    return stack.pop() * stack.pop();
//                case "-" :
//                    return - stack.pop() + stack.pop();
//                case "/" :
//                    Integer right = stack.pop();
//                    return stack.pop() / right;
//                default:
//                    stack.push(Integer.parseInt(token));
//            }
//        }
//        return stack.pop();
//    }
}
