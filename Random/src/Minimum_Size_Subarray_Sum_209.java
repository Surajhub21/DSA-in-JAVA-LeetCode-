public class Minimum_Size_Subarray_Sum_209 {

    public static void main(String[] args) {

        int[] arr = {2,3,1,2,4,3};
        int target = 7;

        int ans = minSubArrayLen(target, arr);
        System.out.println(ans);
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int window = Integer.MAX_VALUE;

        int l = 0;
        int r = 0;

        int sum = 0;
        while (r < n) {

            sum += nums[r];

            if (sum >= target) {

                int size = r - l + 1;
                window = Math.min(size , window);

                while(l < r){
                    sum -= nums[l];
                    l++;

                    if(sum < target){
                        break;
                    }
                    size = r - l + 1;
                    window = Math.min(size , window);
                }


            }

            r++;
        }

        return window;
    }
}
