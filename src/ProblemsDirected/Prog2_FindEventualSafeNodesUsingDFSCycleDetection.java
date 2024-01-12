package ProblemsDirected;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prog2_FindEventualSafeNodesUsingDFSCycleDetection {
    public static void main(String[] args) {
        int[][] edges = {
                {0,1},
                {2,3},
                {1,2},
                {3,4},
                {3,5},
                {4,6},
                {5,6},
                {6,7},
                {8,1},
                {8,9},
                {9,10},
                {10,8},
                {11,9}
        };
        int nodes = 11;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= nodes; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] a : edges){
            adj.get(a[0]).add(a[1]);
        }
        List<Integer> ans = solve(nodes, adj);
        System.out.println(ans);
    }

    private static List<Integer> solve(int nodes, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[nodes+1];
        boolean[] pathVis = new boolean[nodes+1];
        List<Integer> ans = new ArrayList<>();
        boolean[] safeDp = new boolean[nodes+1];
        for(int i = 0; i <= nodes; i++){
            if(!vis[i]){
                dfsCycle(i,vis,pathVis,adj,safeDp);
            }
        }
        for(int i = 0; i <= nodes; i++){
            if(safeDp[i]){
                ans.add(i);
            }
        }
        return ans;
    }

    private static boolean dfsCycle(int node, boolean[] vis, boolean[] pathVis, ArrayList<ArrayList<Integer>> adj,boolean[] safeDp) {
        vis[node] = true;
        pathVis[node] = true;
        safeDp[node] = false;
        for(Integer i : adj.get(node)){
            if(!vis[i]){
                if(dfsCycle(i,vis,pathVis,adj,safeDp)) return true;
            }else{
                if(pathVis[i]) {
                    return true;
                }
            }
        }
        pathVis[node] = false;
        safeDp[node] = true;
        return false;
    }
}
