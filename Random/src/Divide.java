import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Divide {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 9, 18};

        List<Integer> ans = largestDivisibleSubset(arr);

        ans.forEach(System.out::println);
    }
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;

        int[] dp = new int[n];
        int[] hash = new int[n];

        Arrays.fill(dp, 1);

        int maxi = 1;
        int lastIndex = 0;

        for (int i = 0; i < n; i++) {

            hash[i] = i;

            for (int prev = 0; prev < i; prev++) {

                if (nums[i] % nums[prev] == 0 &&
                        dp[prev] + 1 > dp[i]) {

                    dp[i] = dp[prev] + 1;
                    hash[i] = prev;
                }
            }

            if (dp[i] > maxi) {
                maxi = dp[i];
                lastIndex = i;
            }
        }

        List<Integer> ans = new ArrayList<>();

        ans.add(nums[lastIndex]);

        while (hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            ans.add(nums[lastIndex]);
        }

        Collections.reverse(ans);

        return ans;
    }

    private static int f(int i, int prv, int[] arr, int[][] dp) {
        if (i == arr.length) {
            return 0;
        }

        if (dp[i][prv] != -1) {
            return dp[i][prv];
        }

        //not take
        int len1 = f(i + 1, prv, arr, dp);

        //take
        int len2 = 0;
        if (prv == 0 || arr[i] % arr[prv - 1] == 0 || arr[prv - 1] % arr[i] == 0) {
            len2 = 1 + f(i + 1, i + 1, arr, dp);
        }

        return dp[i][prv] = Math.max(len1, len2);
    }

    private static int longestDivisibleSubsetTabulation(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {

            for (int p = n; p >= 0; p--) {

                int notTake = dp[i + 1][p];
                int take = 0;
                if (p == 0 || arr[i] % arr[p - 1] == 0 || arr[p - 1] % arr[i] == 0) {
                    take = 1 + dp[i + 1][i + 1];
                }
                dp[i][p] = Math.max(notTake, take);
            }
        }

        return dp[0][0];
    }

}
