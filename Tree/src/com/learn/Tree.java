package com.learn;

import java.util.HashMap;
import java.util.Map;

public class Tree {

    Map<Integer , Integer> map = new HashMap<>();

    public void bottomView(Node root , int idx){
        if(root == null) return;

        bottomView(root.left , idx-1);
        bottomView(root.left , idx+1);

        map.put(idx , root.data);
    }

    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
        }
    }
}
