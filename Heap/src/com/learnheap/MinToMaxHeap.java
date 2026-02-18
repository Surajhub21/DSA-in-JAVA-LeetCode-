package com.learnheap;

import java.util.ArrayList;
import java.util.Arrays;

public class MinToMaxHeap {

    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        int[] arr = {5, 7, 9, 8, 11, 12, 14, 13, 10};

        convertToMax(arr);

        Object[] res = list.toArray();
        System.out.println(Arrays.toString(res));
    }

    private static int[] convertToMax(int[] arr) {
        int[] res = arr;

        for(int i = arr.length - 1; i >= 0; i--){
            insert(res[i]);
        }

        return res;
    }

    private static int parent(int i){
        return (i-1)/2;
    }

    private static void swap(int first , int second){
        int temp = list.get(first);
        list.set(first , list.get(second));
        list.set(second , temp);
    }
    private static void insert(int value) {
        list.add(value);

        upHeap(list.size() - 1);
    }

    private static void upHeap(int i) {
        if(i == 0){
            return;
        }

        int parent = parent(i);

        if(list.get(parent) < list.get(i)){
            swap(parent , i);
            upHeap(parent);
        }
    }
}
