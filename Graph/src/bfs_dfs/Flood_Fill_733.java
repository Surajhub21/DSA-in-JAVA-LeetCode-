package bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;

public class Flood_Fill_733 {

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == 0) return new int[image.length][image[0].length];
        int rows = image.length, cols = image[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr , sc});
        int sColor = image[sr][sc];
        image[sr][sc] = color;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty()){
            int size = q.size();

            for (int s = 0; s < size; s++) {

                int[] cur = q.poll();
                int r = cur[0], c = cur[1];

                for (int[] d : dirs) {

                    int nr = r + d[0], nc = c + d[1];

                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && image[nr][nc] == sColor) {
                        image[nr][nc] = color;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
        }
        return image;
    }

    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int sr = 1, sc = 1, newColor = 2;

        int[][] result = floodFill(image, sr, sc, newColor);
        for (int[] row : result) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }
}
