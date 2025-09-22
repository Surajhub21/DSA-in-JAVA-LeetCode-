package com.solveproblem;

import java.util.PriorityQueue;

public class Kth_Largest_Element_in_an_Array_215 {

    public static void main(String[] args) {
        int[] arr = {5, 7, 9, 8, 11, 12, 14, 13, 10};
        int k = 2;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a , b) -> b - a);
        for (int i = 0; i < arr.length; i++){
            priorityQueue.add(arr[i]);
        }

        int i = 1;
        while(i < k){
            priorityQueue.poll();
            i++;
        }

        System.out.println(priorityQueue.poll());
    }
}
