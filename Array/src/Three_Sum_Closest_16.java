public class Three_Sum_Closest_16 {

    public int threeSumClosest(int[] nums, int target) {
        if(nums.length == 3) return nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);

        int closes = 0;
        int dif = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length-2; i++){

            int currentDif = Integer.MAX_VALUE;
            int firstElm = nums[i];
            int l = i+1;
            int r = nums.length-1;

            while(l < r){
                int sum = firstElm + nums[l] + nums[r];

                if(sum =< 0 && target > 0){
                    currentDif = Math.abs(sum) + target;
                }
                else if(sum > 0 && target =< 0){
                    currentDif = Math.abs(target) + sum;
                }
                else{
                    currentDif = Math.max(Math.abs(target) , Math.abs(sum)) - Math.min(Math.abs(target) , Math.abs(sum));
                }

                if(currentDif <= dif){
                    closes = sum;
                    l++;
                }
                else{
                    r++;
                }
            }
        }

        return closes;
    }

    public static void main(String[] args) {

    }
}
