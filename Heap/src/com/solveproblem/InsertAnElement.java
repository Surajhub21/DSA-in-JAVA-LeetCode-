package com.solveproblem;

import java.util.ArrayList;
import java.util.List;

public class InsertAnElement {

    public static List<Integer> list = new ArrayList<>();

    public static void insert(int v) {
        if(list.isEmpty()) {
            list.add(v);
            return;
        }

        int l = 0, r = list.size() - 1;

        while(l <= r) {
            int mid = l + (r - l) / 2;

            if(list.get(mid) < v) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        list.add(l, v);
    }

    public static void main(String[] args) {
        insert(1);
        insert(4);
        insert(2);
        insert(8);
        insert(3);
        insert(5);
        insert(0);
        insert(6);
    }
}
