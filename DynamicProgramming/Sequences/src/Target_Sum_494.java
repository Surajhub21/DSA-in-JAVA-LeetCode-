public class Target_Sum_494 {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 1, 1, 1, 1};
        int result = findTargetSumWays(nums.length-1, 0 , nums , 3);
        System.out.println(result);
    }

    public static int findTargetSumWays(int n, int sum, int[] nums, int target) {
        //base case
        if(n == 0){

            if (sum > target) {
                if(sum-nums[0] == target){
                    return 1;
                }
                else{
                    return 0;
                }
            }
            else{
                if(sum+nums[0] == target){
                    return 1;
                }
                else{
                    return 0;
                }
            }
        }

        //on every index it can be + or -.
        int plus = findTargetSumWays(n-1, sum+nums[n] , nums, target);
        int minus = findTargetSumWays(n-1, sum-nums[n] , nums, target);

        return plus+minus;
    }
}
