package com.practice;

public class Climbing_Stairs_70 {

    private static int climbStairs(int n) {
        if(n == 0) return 1;
        if(n == 1) return 1;

        int left = climbStairs(n-1);

        int right = climbStairs(n-2);

        return left + right;
    }

    public static void main(String[] args) {
        int r = climbStairs(4);
        System.out.println(r);
    }
}
