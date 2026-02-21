package ShortestPathAlgo;

import java.util.LinkedList;
import java.util.Queue;

public class Shortest_Path_in_Binary_Matrix_1091 {

    public static void main(String[] args) {
        Shortest_Path_in_Binary_Matrix_1091 sp = new Shortest_Path_in_Binary_Matrix_1091();
        //[[0,0,0],[0,1,0],[0,0,0]]
        int[][] grid = {
                { 0, 0, 0 },
                { 0, 1, 0 },
                { 0, 0, 0 }
        };
        System.out.println(sp.shortestPathBinaryMatrix(grid));
        int i = 0;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;

        int[][] dirs = {
                {1,0},{-1,0},{0,1},{0,-1},
                {1,1},{1,-1},{-1,1},{-1,-1}
        };

        boolean[][] vis = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0, 0, 1}); // row, col, distance
        vis[0][0] = true;

        while (!q.isEmpty()) {

            int[] cur = q.poll();
            int i = cur[0], j = cur[1], dist = cur[2];

            if (i == n-1 && j == n-1) return dist;

            for (int[] d : dirs) {
                int ni = i + d[0];
                int nj = j + d[1];

                if (ni >= 0 && nj >= 0 && ni < n && nj < n
                        && grid[ni][nj] == 0
                        && !vis[ni][nj]) {

                    vis[ni][nj] = true;
                    q.add(new int[]{ni, nj, dist + 1});
                }
            }
        }

        return -1;
    }
}
