package TopologicalSort;

import java.util.*;

public class Find_Eventual_Safe_States_802 {

    public static void main(String[] args) {
        Find_Eventual_Safe_States_802 obj = new Find_Eventual_Safe_States_802();
        //[[2,3],[2,3,4],[3,4],[],[1]]
        int[][] graph = {{2,3},{2,3,4},{3,4},{},{1}};
        List<Integer> result = obj.eventualSafeNodes(graph);
        System.out.println(result);
        int i = 0;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();

        Set<Integer> tNode = new HashSet<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            if(graph[i].length == 0){
                tNode.add(i);
                continue;
            }
            for (int j = 0; j < graph[i].length; j++) {
                adj.get(i).add(graph[i][j]);
            }
        }

        int[] vis = new int[n];
        int[] dfsVis = new int[n];

        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(vis[i] != 1){
                dfs(i , adj , tNode , vis , dfsVis , result);
            }
        }

        Collections.sort(result);
        return result;
    }

    private boolean dfs(int node , List<List<Integer>> adj , Set<Integer> tNode, int[] vis, int[] dfsVis , List<Integer> result){
        vis[node] = 1;
        dfsVis[node] = 1;

        for (int nei : adj.get(node)) {
            if(tNode.contains(nei)){
                continue;
            }
            else if (vis[nei] == 0) {
                if (!dfs(nei, adj, tNode, vis, dfsVis, result)) {
                    return false;
                }
            }
            else if (dfsVis[nei] == 1) {
                return false;
            }
        }

        dfsVis[node] = 0;
        result.add(node);
        return true;
    }
}
