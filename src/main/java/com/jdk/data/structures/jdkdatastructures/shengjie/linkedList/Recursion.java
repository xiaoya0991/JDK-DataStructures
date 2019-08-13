package com.jdk.data.structures.jdkdatastructures.shengjie.linkedList;

/**
 * compute sum of arr[1,...,n)
 */
public class Recursion {
    public int l;
    private int[] arr;

    public static int sum(int arr[], int l){
        if(l == arr.length)
            return 0;
        else
            return arr[l] + sum(arr, l + 1);
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        int result = sum(arr,0);
        System.out.println(result);
    }
}
