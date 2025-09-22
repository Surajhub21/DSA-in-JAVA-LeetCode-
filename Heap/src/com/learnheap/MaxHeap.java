package com.learnheap;

import java.util.ArrayList;

public class MaxHeap<T extends Comparable<T>> {
    ArrayList<T> list;

    public MaxHeap(){
        list = new ArrayList<>();
    }

    private void swap(int first , int second){
        T temp = list.get(first);
        list.set(first , list.get(second));
        list.set(second , temp);
    }

    private int parent(int i){
        return (i - 1)/2;
    }
    private int left(int i){
        return i * 2 + 1;
    }
    private int right(int i){
        return i * 2 + 2;
    }

    public void insert(T value){
        list.add(value);
        upHeap(list.size() - 1);
    }

    private void upHeap(int i) {
        if(i == 0){
            return;
        }
        int parent = parent(i);

        if(list.get(i).compareTo(list.get(parent)) > 0){
            swap(i , parent);
            upHeap(parent);
        }
    }

    public T remove() throws Exception{
        if(list.isEmpty()){
            throw new Exception("Removing from an empty heap!");
        }

        T temp = list.get(0);

        T last = list.remove(list.size() - 1);

        if(!list.isEmpty()){
            list.set(0 , last);
            downHeap(0);
        }
        return temp;
    }

    private void downHeap(int i) {
        int max = i;
        int left = left(i);
        int right = right(i);

        if(left < list.size() && list.get(max).compareTo(list.get(left)) < 0){
            max = left;
        }
        if(right < list.size() && list.get(max).compareTo(list.get(right)) < 0){
            max = right;
        }

        if(max != i){
            swap(max , i);
            downHeap(max);
        }
    }

    public void print(){
        System.out.println(list);
    }

}
