package ProblemsDirected.TopologicalSorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Prog1_TopologicalSortingDFS {
    public static void main(String[] args) {
        int[][] edges = {
                {5,0},
                {5,2},
                {2,3},
                {4,0},
                {4,1},
                {3,1}
        };
        List<List<Integer>> adj = new ArrayList<>();
        int nodes = 6;
        for(int i = 0; i < nodes; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
        }
        System.out.println("Topological Sort linear ordering : "+ Arrays.toString(solve(nodes,adj)));
    }

    private static int[] solve(int nodes, List<List<Integer>> adj) {
        boolean[] vis = new boolean[nodes];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < nodes; i++){
            if(!vis[i]){
                dfsTopo(i,vis,adj,stack);
            }
        }
        int[] ans = new int[stack.size()];
        for(int i = 0; i < ans.length; i++){
            ans[i] = stack.pop();
        }
        return ans;
    }
    private static void dfsTopo(int node, boolean[] vis, List<List<Integer>> adj, Stack<Integer> stack){
        vis[node] = true;
        for(int i : adj.get(node)){
            if(!vis[i]){
                dfsTopo(i,vis,adj,stack);
            }
        }
        stack.push(node);
    }

}
