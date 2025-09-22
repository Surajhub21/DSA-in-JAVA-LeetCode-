package com.learnheap;

import java.util.PriorityQueue;

public class CheckIfAnArrayRepresentMinHeapOrNot {

    public static boolean checkMinHead(int[] arr){

        for(int i = 0; i <= arr.length/2-1; i++){

            if(arr[i] > arr[2*i + 1] || arr[i] > arr[2*i + 2]){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 9, 8, 11, 12, 14, 13, 10};
//        System.out.println(checkMinHead(arr));

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a , b) -> b - a);
        for (int i = 0; i < arr.length; i++){
            priorityQueue.add(arr[i]);
        }

        int i = 1;
        while(i < 2){
            priorityQueue.poll();
            i++;
        }

        System.out.println(priorityQueue.poll());
    }
}
