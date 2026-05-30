public class Minimum_Path_Sum_64 {
    public static void main(String[] args) {
        int n = minPathSum(new int[][]{
                {1 , 3 , 1},
                {1 , 5 , 1},
                {4 , 2 , 1}
        });

        System.out.println(n);
    }
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                if(i == 0 && j == 0){
                    dp[0][0] = grid[0][0];
                    continue;
                }

                int up = (i > 0) ?  grid[i][j] + dp[i-1][j] : 500;
                int left = (j > 0) ? grid[i][j] + dp[i][j-1] : 500;

                dp[i][j] = Math.min(up, left);
            }
        }

        return dp[m-1][n-1];
        // return f(grid , grid.length-1, grid[0].length-1);
    }
}
