package DijkstrasAlgorithm;

import java.util.*;
class Pair{
    int node;
    int weight;
    public Pair(int node, int weight){
        this.node = node;
        this.weight = weight;
    }
}
public class Prog2_PrintShortestPath {
    public static void main(String[] args) {
        int[][] edges = {
                {1,2,2},
                {1,4,1},
                {2,3,4},
                {2,5,5},
                {3,4,3},
                {3,5,1}
        };
        int nodes = 5;
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i <= nodes; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(new Pair(edge[1],edge[2]));
            adj.get(edge[1]).add(new Pair(edge[0],edge[2]));
        }
        List<Integer> ans = solve(nodes,adj,1,nodes);
        System.out.println(ans);
    }

    private static List<Integer> solve(int nodes, List<List<Pair>> adj, int source, int destination) {
        int[] distance = new int[nodes+1];
        Arrays.fill(distance,(int)(1e9));
        int[] parent = new int[nodes+1];
        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)-> a.weight - b.weight);
        distance[source] = 0;
        pq.add(new Pair(source,0));
        while (!pq.isEmpty()){
            Pair out = pq.poll();
            int node = out.node;
            int weight = out.weight;
            for(Pair p : adj.get(node)){
                int adjNode = p.node;
                int adjWeight = p.weight;
                if(weight + adjWeight < distance[adjNode]){
                    distance[adjNode] = weight + adjWeight;
                    pq.add(new Pair(adjNode,distance[adjNode]));
                    parent[adjNode] = node;
                }
            }
        }
        List<Integer> path = new ArrayList<>();
        if(distance[destination] == 1e9){
            path.add(-1);
            return path;
        }
        int node = destination;
        while(parent[node] != node){
            path.add(node);
            node = parent[node];
        }
        path.add(source);
        Collections.reverse(path);
        return path;
    }
}
