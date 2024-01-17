package ProblemsDirected.TopologicalSorting;

import java.util.*;

public class Prog8_ShortestPathIndirectedAcyclicGraphUsingTopo {
    public static void main(String[] args) {
        int n = 10;
        int m = 24;
        int[][] edges = {
                {0, 2, 6},
                {0, 3, 7},
                {0, 4, 9},
                {0, 6, 8},
                {0, 7, 6},
                {1, 2, 6},
                {1, 3, 7},
                {1, 5, 10},
                {1, 6, 1},
                {1, 7, 4},
                {2, 3, 3},
                {2, 6, 10},
                {2, 8, 8},
                {2, 9, 10},
                {3, 5, 3},
                {3, 6, 10},
                {3, 7, 5},
                {5, 6, 9},
                {5, 7, 7},
                {6, 7, 7},
                {6, 8, 8},
                {6, 9, 8},
                {7, 9, 1},
                {8, 9, 6}
        };
        System.out.println("Shortest Distance from node 0 is "+ Arrays.toString(solve(n,m,edges)));
    }
    private static class Pair{
        int node;
        int weightDistance;
        public Pair(int node, int weightDistance){
            this.node = node;
            this.weightDistance = weightDistance;
        }
    }
    private static int[] solve(int n, int m, int[][] edges) {
        List<List<Pair>> adj= new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(new Pair(edge[1],edge[2]));
        }
        boolean[] vis = new boolean[n];
        Stack<Integer> topo = new Stack<>();
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                dfsTopoSort(i,vis,adj,topo);
            }
        }
        int[] dist = new int[n];
        Arrays.fill(dist,(int)(1e9));
        dist[0] = 0;
        while (!topo.isEmpty()){
            Integer i = topo.pop();
            for(Pair p : adj.get(i)){
                int node = p.node;
                int nodeDistance = p.weightDistance;
                if(nodeDistance + dist[i] < dist[node]){
                    dist[node] = nodeDistance + dist[i];
                }
            }
        }
        for(int  i = 0; i < n; i++){
            if(dist[i] == 1e9) dist[i] = -1;
        }
        return dist;
    }

    private static void dfsTopoSort(int node,boolean[] vis, List<List<Pair>> adj, Stack<Integer> topo) {
        vis[node] = true;
        for(Pair i : adj.get(node)){
            if(!vis[i.node]){
                dfsTopoSort(i.node,vis,adj,topo);
            }
        }
        topo.push(node);
    }
}
