package com.practice;

import java.util.ArrayList;
import java.util.List;

public class RecursionSubsequence {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3 , 2};
        int n = arr.length;
        int k = 4;
        List<Integer> list = new ArrayList<>();

        printS(0 , list, 0 , k , arr , n);
    }

    private static void printS(int i, List<Integer> list, int s, int sum, int[] arr, int n) {
        if (i == n) {
            if(s == sum){
                System.out.println(list);
            }
            return;
        }

        //pick
        list.add(arr[i]);
        s += arr[i];
        printS(i + 1, list, s, sum, arr, n);

        //not-pick
        list.removeLast();
        s -= arr[i];
        printS(i + 1, list, s, sum, arr, n);
    }


}
