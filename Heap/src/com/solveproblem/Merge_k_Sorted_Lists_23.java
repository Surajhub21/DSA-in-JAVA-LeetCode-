package com.solveproblem;

import java.util.ArrayList;
import java.util.Arrays;

public class Merge_k_Sorted_Lists_23 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private static ArrayList<ListNode> list;

    public static void main(String[] args) {

//        ListNode[] lists = new ListNode[3];
//        lists[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
//        lists[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
//        lists[2] = new ListNode(2, new ListNode(6));
        ListNode[] lists = new ListNode[2];

        list = new ArrayList<>(lists.length);

        ListNode head = mergeKLists(lists);

        while(head != null){
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("NULL");

    }

    public static ListNode mergeKLists(ListNode[] arr) {
        ListNode head = new ListNode();
        //create k length minheap first
        for(int i = 0; i < arr.length; i++){
            ListNode cur = arr[i];
            if(cur != null) {
                list.add(cur);
                upHeap(list.size() - 1);
            }
        }

        //pop the top and add into ListNode
        ListNode cur = head;
        while (true){
            ListNode node = remove();
            if(node != null){
                cur.next = node;
                cur = cur.next;
            }
            else {
                break;
            }
        }

        return head;
    }

    private static ListNode remove(){
        if(list.isEmpty()){
            return null;
        }

        ListNode temp = list.getFirst();
        if(list.size()-1 != 0) {
            if (temp.next != null) {
                list.set(0, temp.next);
                downHeap(0);
            } else {
                ListNode last = list.remove(list.size() - 1);
                list.set(0, last);
                downHeap(0);
            }
        }
        else {
            list.removeFirst();
        }

        return temp;
    }

    private static void downHeap(int i){
        int min = i;
        int left = (i * 2) + 1;
        int right = (i * 2) + 2;

        if(left < list.size() && list.get(min).val > list.get(left).val){
            min = left;
        }

        if(right < list.size() && list.get(min).val > list.get(right).val){
            min = right;
        }

        if(min != i){
            ListNode temp = list.get(min);
            list.set(min , list.get(i));
            list.set(i , temp);
            downHeap(min);
        }
    }

    private static void upHeap(int i) {
        if(i == 0){
            return;
        }

        int parent = (i-1)/2;

        if(list.get(parent).val > list.get(i).val){
            ListNode temp = list.get(i);
            list.set(i , list.get(parent));
            list.set(parent , temp);
            upHeap(parent);
        }
    }
}
