package bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix_01_542 {

    public int[][] updateMatrix(int[][] mat) {
        if (mat.length == 0)
            return mat;

        int row = mat.length;
        int col = mat[0].length;

        Queue<int[]> q = new LinkedList<>();
        int nonZero = 0;
        int[][] visited = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (mat[i][j] == 0) {
                    q.add(new int[] { i, j });
                    visited[i][j] = 1;
                }
                else if(mat[i][j] == 1) nonZero++;
            }
        }

        if(nonZero == 0) return mat;

        int[][] result = new int[row][col];
        int[][] dirs = {{ 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        int step = 1;
        while (!q.isEmpty()) {
            int size = q.size();


            for(int i = 0; i < size; i++){

                int[] cur = q.poll();
                int r = cur[0], c = cur[1];

                for (int[] d : dirs) {

                    int nr = r + d[0], nc = c + d[1];

                    if (nr >= 0 && nr < row && nc >= 0 && nc < col && mat[nr][nc] != 0 && visited[nr][nc] != 1) {
                        result[nr][nc] = step;
                        q.add(new int[]{ nr, nc });
                        visited[nr][nc] = 1;
                    }
                }
            }

            step++;
        }

        return result;
    }

    public static void main(String[] args) {
        Matrix_01_542 solution = new Matrix_01_542();
        int[][] mat = {
            {0,0,0},
            {0,1,0},
            {1,1,1}
        };
        int[][] result = solution.updateMatrix(mat);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
