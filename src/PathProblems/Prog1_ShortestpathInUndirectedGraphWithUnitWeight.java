package PathProblems;

import java.util.*;

public class Prog1_ShortestpathInUndirectedGraphWithUnitWeight {
    public static void main(String[] args) {
        int[][] edges = {
                {0,1},
                {0,3},
                {1,2},
                {2,6},
                {3,4},
                {4,5},
                {5,6},
                {6,7},
                {6,8},
                {7,8}
        };
        int n = 9;
        int m = 10;
        int src = 0;
        System.out.println("shortest path in undirected graph with unit weight : "+ Arrays.toString(solve(n,m,edges,src)));
    }
    public static class Pair{
        int node;
        int distance;
        public Pair(int node, int distance){
            this.node = node;
            this.distance = distance;
        }
    }
    private static int[] solve(int n, int m, int[][] edges, int src) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int[] dist = new int[n];
        Arrays.fill(dist,(int)(1e9));
        dist[src] = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(src,0));
        while (!queue.isEmpty()){
            Pair p = queue.poll();
            int node = p.node;
            int distcnceSrc = p.distance;
            for(Integer i : adj.get(node)){
                int currDist = distcnceSrc + 1;
                if(currDist < dist[i]){
                    dist[i] = currDist;
                    queue.add(new Pair(i,dist[i]));
                }
            }
        }
        for(int i = 0; i < n; i++){
            if(dist[i] == 1e9){
                dist[i] = -1;
            }
        }
        return dist;
    }
}
