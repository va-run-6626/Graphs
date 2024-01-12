package ProblemsDirected;

import java.util.ArrayList;
import java.util.List;

public class Prog1_DetectCycleInADirectedGraphUsingDFS {
    public static void main(String[] args) {
        int[][] edges = {
                {2,3},
                {1,2},
                {3,4},
                {4,5},
                {5,6},
                {3,7},
                {7,5},
                {8,2},
                {8,9},
                {9,10},
                {10,8}
        };
        int nodes = 10;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= nodes; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] a : edges){
            adj.get(a[0]).add(a[1]);
        }
        System.out.println("Cycle Detected : " + solve(nodes,adj));
    }
    private static boolean solve(int nodes, List<List<Integer>> adj){
        boolean[] vis = new boolean[nodes+1];
        boolean[] pathVis = new boolean[nodes+1];
        for(int i = 1; i <= nodes; i++){
            if(!vis[i]){
                if(dfs(i,vis,pathVis,adj)) return true;
            }
        }
        return false;
    }

    private static boolean dfs(int node, boolean[] vis, boolean[] pathVis, List<List<Integer>> adj) {
        vis[node] = true;
        pathVis[node] = true;
        for(Integer i : adj.get(node)){
            if(!vis[i]){
                if(dfs(i,vis,pathVis,adj)) return true;
            }else{
                if(pathVis[i]){
                    return true;
                }
            }
        }
        pathVis[node] = false;
        return false;
    }
}
