package ProblemsUndirected;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Prog12_BipartiteGraphBFS {
    public static void main(String[] args) {
        int[][] adj = {
                {},{2,4,6},{1,4,8,9},{7,8},{1,2,8,9},{6,9},{1,5,7,8,9},{3,6,9},{2,3,4,6,9},{2,4,5,6,7,8}
        };
        System.out.println("Is Bipartite : "+ isBipartite(adj));
    }
    private static boolean isBipartite(int[][] adj){
        int[] color = new int[adj.length];
        Arrays.fill(color,-1);
        for(int a = 0; a < color.length; a++) {
            if(color[a] == -1) {
               if(!bfs(a,color,adj)) return false;
            }
        }
        return true;
    }
    private static boolean bfs(int a, int[] color, int[][] adj){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);
        color[a] = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            int nodeColor = color[node];
            for (int i : adj[node]) {
                if (color[i] == -1) {
                    if (nodeColor == 0) {
                        color[i] = 1;
                    } else {
                        color[i] = 0;
                    }
                    queue.add(i);
                } else if (nodeColor == color[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
