package com.practice;

public class Best_Time_to_Buy_and_Sell_Stock_III_123 {

    public static void main(String[] args) {
        // prices = [3,3,5,0,0,3,1,4]
        //[3,2,6,5,0,3]
        int[] prices = {3 , 2 , 6 , 5 , 0 , 3};
        System.out.println(maxProfit(prices));
        int i = 0;
    }

    public static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];

        for (int i = 0; i < prices.length; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }

        return f(0, prices, 1, dp, 2);
    }

    private static int f(int i, int[] prices, int buy, int[][] dp, int transaction) {

        // base case
        if (i == prices.length) {
            return 0;
        }

        // if already calculated
        if (dp[i][buy] != -1) {
            return dp[i][buy];
        }

        int profit = 0;

        // 1 == can buy
        if (buy == 1) {

            if(transaction > 0) {

                // buy stock
                int canBuy = -prices[i] + f(i + 1, prices, 0, dp, transaction - 1);

                // skip buying
                int notBuy = f(i + 1, prices, 1, dp, transaction);

                profit = Math.max(canBuy, notBuy);


            }

        } else {

            // sell stock
            int sell = prices[i] + f(i + 1, prices, 1, dp, transaction);

            // skip selling
            int notSell = f(i + 1, prices, 0, dp, transaction);

            profit = Math.max(sell, notSell);
        }

        // store answer
        return dp[i][buy] = profit;
    }
}

