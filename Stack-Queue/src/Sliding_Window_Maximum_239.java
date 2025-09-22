import java.util.*;

public class Sliding_Window_Maximum_239 {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 1) return new int[]{nums[0]};
        if(k == 1) return nums;

        List<Integer> arr = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();

        for(int i = 0; i < nums.length; i++){

            if(!dq.isEmpty() && dq.peekFirst() <= i - k)
            {
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i])
            {
                dq.pollLast();
            }

            if(i >= k - 1){
                arr.add(nums[dq.peekFirst()]);
            }
        }
        return arr.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] a = maxSlidingWindow(new int[]{7 , 4 , 2}, 2);

        for(int i : a){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
