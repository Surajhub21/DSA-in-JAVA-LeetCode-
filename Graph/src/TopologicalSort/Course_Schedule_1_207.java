package TopologicalSort;

import java.util.ArrayList;
import java.util.List;

public class Course_Schedule_1_207 {

    public static void main(String[] args) {
        Course_Schedule_1_207 obj = new Course_Schedule_1_207();
        int numCourses = 4;
        int[][] prerequisites = {{1 , 0} ,{2 , 0} , {3 , 2} , {3, 1}};
        boolean b = obj.canFinish(numCourses, prerequisites);
        System.out.println(b);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Step 1: Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
        }

        int[] vis = new int[numCourses];
        int[] dfsVis = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (vis[i] == 0) {
                if (checkCycle(i, adj, vis, dfsVis)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean checkCycle(int node, List<List<Integer>> adj,
                               int[] vis, int[] dfsVis) {

        vis[node] = 1;
        dfsVis[node] = 1;

        for (int nei : adj.get(node)) {

            if (vis[nei] == 0) {
                if (checkCycle(nei, adj, vis, dfsVis)) {
                    return true;
                }
            }
            else if (dfsVis[nei] == 1) {
                return true;
            }
        }

        dfsVis[node] = 0;
        return false;
    }
}
