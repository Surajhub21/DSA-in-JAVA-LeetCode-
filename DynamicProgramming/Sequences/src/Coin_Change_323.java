import java.util.Arrays;

public class Coin_Change_323 {

    public static void main(String[] args) {
        int num = coinChange(new int[]{1, 2, 5}, 11);
        System.out.println(num);
    }

    public static int coinChange(int[] coins, int amount) {
        return coinChange2(coins.length - 1, coins, amount);
    }

    private static int coinChange2(int n, int[] coins, int amount) {
        // Base case
        if (n == 0) {
            if (amount % coins[0] == 0) {
                return amount / coins[0];
            } else {
                return (int) 1e9; // treat as infinity
            }
        }

        // Not pick
        int notTake = coinChange2(n - 1, coins, amount);

        // Pick
        int take = (int) 1e9;
        if (coins[n] <= amount) {
            take = 1 + coinChange2(n, coins, amount - coins[n]);
        }

        return Math.min(take, notTake);
    }
}
