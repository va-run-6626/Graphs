package ProblemsUndirected;

import java.util.*;

public class Prog13_BipartiteGraphDFS {
    public static void main(String[] args) {
        int[][] adj = {
                {},{2,4,6},{1,4,8,9},{7,8},{1,2,8,9},{6,9},{1,5,7,8,9},{3,6,9},{2,3,4,6,9},{2,4,5,6,7,8}
        };
        System.out.println("Is Bipartite : "+ isBipartite(adj));
    }

    private static boolean isBipartite(int[][] adj) {
        int[] color = new int[adj.length];
        Arrays.fill(color,-1);
        for(int i = 0; i < color.length; i++){
            if(color[i] == -1){
                if(!dfs(i,color,adj,0)) return false;
            }
        }
        return true;
    }

    private static boolean dfs(int i, int[] color, int[][] adj,int Col) {
        color[i] = Col;
        for(int node : adj[i]){
            if(color[node] == -1){
                if(!dfs(node,color,adj,1-Col)) return false;
            }else if(color[node] == Col){
                return false;
            }
        }
        return true;
    }
}
