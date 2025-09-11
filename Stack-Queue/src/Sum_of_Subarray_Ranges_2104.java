import java.util.Stack;

public class Sum_of_Subarray_Ranges_2104 {

    public int[] findNSE(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            res[i] = stack.isEmpty() ? arr.length : stack.peek();
            stack.push(i);
        }

        return res;
    }

    /*
        find next previous small element equal
    */
    public int[] findPSEE(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }

            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return res;
    }

    //find maxima
    public int[] findNLE(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }

            res[i] = stack.isEmpty() ? arr.length : stack.peek();
            stack.push(i);
        }

        return res;
    }

    /*
        find next previous small element equal
    */
    public int[] findPLEE(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }

            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return res;
    }

    public long sumSubarrayMins(int[] arr) {
        int[] nse = findNSE(arr);
        int[] pse = findPSEE(arr);

        long total = 0;

        for (int i = 0; i < arr.length; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;
            total += left * right * arr[i];
        }
        return total;
    }

    public long sumSubarrayMaxs(int[] arr) {
        int[] nle = findNLE(arr);
        int[] ple = findPLEE(arr);

        long total = 0;

        for (int i = 0; i < arr.length; i++) {
            long left = i - ple[i];
            long right = nle[i] - i;
            total += left * right * arr[i];
        }
        return total;
    }

    public long subArrayRanges(int[] nums) {
        return sumSubarrayMaxs(nums) - sumSubarrayMins(nums);
    }

    public static void main(String[] args) {
        Sum_of_Subarray_Ranges_2104 s = new Sum_of_Subarray_Ranges_2104();
        long l = s.subArrayRanges(new int[]{1, 3, 4, 2, 1});
        System.out.println(l);
    }
}
