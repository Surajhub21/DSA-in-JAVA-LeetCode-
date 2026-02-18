package com.learn;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Insert_Interval_57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> marge = new ArrayList<>();

        int r = intervals.length;
        //finding the position
        int pos = 0;
        for(int i = 0; i < r; i++){
            if(intervals[i][0] <= newInterval[0]){
                pos++;
            }
            else {
                break;
            }
        }
        //insert
        int j = 0;
        for(int i = 0; i < r+1; i++){
            if(i == pos){
                marge.add(newInterval);
            }else {
                marge.add(intervals[j++]);
            }
        }
        List<int[]> result = new ArrayList<>();
        //marge
        for(int i = 0; i < r+1; i++){

            if(result.isEmpty()) {
                int firstLeft = marge.get(i)[0];
                int firstRight = marge.get(i)[1];
                int secondLeft = marge.get(i + 1)[0];
                int secondRight = marge.get(i + 1)[1];
                if (firstLeft <= secondLeft && secondLeft <= firstRight) {
                    if(firstRight < secondRight) {
                        result.add(new int[]{firstLeft, secondRight});
                    }
                    else{
                        result.add(new int[]{firstLeft, firstRight});
                    }
                } else {
                    result.add(marge.get(i));
                    result.add(marge.get(i+1));
                }
                i++;
            }
            else{
                int resultLeft = result.getLast()[0];
                int resultRight = result.getLast()[1];
                int margeLeft = marge.get(i)[0];
                int margeRight = marge.get(i)[1];
                if (resultLeft <= margeLeft && margeLeft <= resultRight) {
                    result.removeLast();
                    if(resultRight < margeRight) {
                        result.add(new int[]{resultLeft, margeRight});
                    }
                    else {
                        result.add(new int[]{resultLeft, resultRight});
                    }
                }
                else {
                   result.add(marge.get(i));
                }
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = { {12,16} , {6,7}, {1,2}, {3,5}, {8,10} };
//        int[] newInterval = {4,8};
//        Insert_Interval_57 obj = new Insert_Interval_57();
//        int[][] merged = obj.insert(intervals, newInterval);
//        System.out.print("[");
//        for (int i = 0; i < merged.length; i++) {
//            System.out.print("[" + merged[i][0] + "," + merged[i][1] + "]");
//            if (i != merged.length - 1) System.out.print(",");
//        }
//        System.out.println("]");

        QuickSort(intervals , 0 , intervals.length-1);
    }

    private static void QuickSort(int[][] intervals , int l , int r) {

        if(l < r){
            int quick = sort(intervals , l , r);

            QuickSort(intervals , l , quick-1);
            QuickSort(intervals , quick+1, r);
        }
    }

    private static int sort(int[][] intervals , int l , int r) {
        int pivot = intervals[r][0];

        //future pivot point
        int i = l-1;

        for(int j = l; j <= r-1;j++){
            if (intervals[j][0] < pivot) {
                i++;
                //swap
                int[] temp = intervals[i];
                intervals[i] = intervals[j];
                intervals[j] = temp;
            }
        }

        int[] temp = intervals[i+1];
        intervals[i+1] = intervals[r];
        intervals[r] = temp;
        return i+1;
    }
}
