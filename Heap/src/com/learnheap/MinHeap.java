package com.learnheap;

import java.util.ArrayList;

public class MinHeap<T extends Comparable<T>> {
    private ArrayList<T> list;

    public MinHeap(){
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

    private void upHeap(int idx){
        if(idx == 0){
            return;
        }
        int p = parent(idx);
        if(list.get(idx).compareTo(list.get(p)) < 0){
            swap(idx , p);
            upHeap(p);
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

    private void downHeap(int idx){
        int min = idx;
        int left = left(idx);
        int right = right(idx);

        if(left < list.size() && list.get(min).compareTo(list.get(left)) > 0){
            min = left;
        }

        if(right < list.size() && list.get(min).compareTo(list.get(right)) > 0){
            min = right;
        }

        if(min != idx){
            swap(min , idx);
            downHeap(min);
        }
    }

    public void print(){
        System.out.println(list);
    }

    public ArrayList<T> heapSort() throws Exception{
        ArrayList<T> data = new ArrayList<>();

        while (!list.isEmpty()){
            data.add(this.remove());
        }

        return data;
    }
}
