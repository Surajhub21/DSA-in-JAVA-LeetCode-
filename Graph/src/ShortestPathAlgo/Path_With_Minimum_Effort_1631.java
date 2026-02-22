package ShortestPathAlgo;

import java.util.LinkedList;
import java.util.Queue;

public class Path_With_Minimum_Effort_1631 {

    public static void main(String[] args) {
        Path_With_Minimum_Effort_1631 sp = new Path_With_Minimum_Effort_1631();
        //[[1,2,2],[3,8,2],[5,3,5]]
        int[][] grid = {
                { 1, 2, 2 },
                { 3, 8, 2 },
                { 5, 3, 5 }
        };
        System.out.println(sp.minimumEffortPath(grid));
        int i = 0;
    }

    public int minimumEffortPath(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        int[][] vis = new int[rows][cols];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                vis[i][j] = -1;
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0, 0});
        vis[0][0] = 0;

        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while(!q.isEmpty()){

            int[] cur = q.poll();
            int i = cur[0], j = cur[1] , dif = cur[2];

            for(int[] d : dirs){
                int ni = i + d[0], nj = j + d[1];

                if(ni >= 0 && ni < rows &&
                        nj >= 0 && nj < cols &&
                        (vis[ni][nj] == -1 || (Math.abs(heights[i][j] - heights[ni][nj]) < vis[ni][nj] && dif < vis[ni][nj]))
                ){
                    int curDif = Math.max(dif, Math.abs(heights[i][j] - heights[ni][nj]));
                    vis[ni][nj] = curDif;
                    q.add(new int[]{ni,nj, curDif});
                }
            }
        }

        return vis[rows-1][cols-1];
    }
}
