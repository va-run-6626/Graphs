package Traversals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prog2_DepthFirstSearch {
    public static void main(String[] args) {
        int[][] edges = {
                {1,2},
                {1,3},
                {2,5},
                {2,6},
                {3,7},
                {3,4},
                {7,8},
                {4,8}
        };
        int nodes = 8;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= nodes; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] i : edges){
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }
        System.out.println("DFS traversal :");
        dfsTraversal(nodes,adj);
    }
    private static void dfsTraversal(int nodes, List<List<Integer>> adj){
        boolean[] vis = new boolean[nodes+1];
        Arrays.fill(vis,false);
        vis[1] = true;
        dfsRecursive(vis,adj,1);
    }
    private static void dfsRecursive(boolean[]vis, List<List<Integer>> adj, int node){
        vis[node] = true;
        System.out.print(node + ", ");

        for(Integer i : adj.get(node)){
            if(!vis[i]){
                dfsRecursive(vis,adj,i);
            }
        }
    }
}