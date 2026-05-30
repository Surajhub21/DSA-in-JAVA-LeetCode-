package com.learn;

public class Ninja_Training {

    public static void main(String[] args) {
        int[][] days = {
                {10 , 50 , 1},
                {5 , 100 , 11}
        };

        System.out.println(f(days, days.length-1, 3));
    }

    private static int f(int[][] days, int day, int last) {
        if(day == 0){
            int max = 0;
            for(int i = 0; i <= 2; i++){
                if(i != last){
                    max = Math.max(max , days[0][i]);
                }
            }
            return max;
        }

        int max = 0;
        for(int i = 0; i <= 2; i++){
            if(i != last){
                int point = days[day][i] + f(days, day - 1, i);

                max = Math.max(max , point);
            }
        }

        return max;
    }
}
