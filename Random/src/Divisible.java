import java.util.*;

public class Divisible {

    static List<List<Integer>> best = new ArrayList<>();

    public static void main(String[] args) {

        int target = 7;
        int[] arr = {2, 3, 5, 7};

        f(0, target, arr, new ArrayList<>());

        System.out.println(best);
    }

    private static void f(int i, int target, int[] arr, List<Integer> curr) {
        //target achieved
        if(target == 0){

            best.add(new ArrayList<>(curr));
            return;
        }
        //out of bounds
        if(i == arr.length || target < 0){
            return;
        }

        //take same element again
        curr.add(arr[i]);

        f(i, target - arr[i], arr, curr);

        curr.remove(curr.size() - 1);

        //skip current element
        f(i + 1, target, arr, curr);
    }
}