package DijkstrasAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Prog1_DijkstarsAlgorithmUsingPriorityQueue {
    public static void main(String[] args) {
        int[][] edges = {
                {0,1,4},
                {0,2,4},
                {1,2,2},
                {2,3,3},
                {2,4,1},
                {2,5,6},
                {3,5,2},
                {4,5,3}
        };
        int source = 0;
        int nodes = 6;

        List<List<AdjPair>> adj = new ArrayList<>();
        for(int i = 0; i < nodes; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(new AdjPair(edge[1],edge[2]));
            adj.get(edge[1]).add(new AdjPair(edge[0],edge[2]));
        }
        System.out.println("Shortest Path :");
        System.out.println(Arrays.toString(new int[]{0,1,2,3,4,5}));
        System.out.println(Arrays.toString(dijkstarsShortestPath(adj,source,nodes)));
    }
    public static class Pair{
        int distance;
        int node;
        public Pair(int distance, int node){
            this.distance = distance;
            this.node = node;
        }
    }
    public static class AdjPair{
        int node;
        int distance;
        public AdjPair(int node, int distance){
            this.distance = distance;
            this.node = node;
        }
    }
    private static int[] dijkstarsShortestPath(List<List<AdjPair>> adj, int source,int nodes) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.distance - b.distance);
        int[] distance = new int[nodes];
        Arrays.fill(distance, (int) (1e9));
        distance[source] = 0;
        pq.add(new Pair(0,source));
        while (!pq.isEmpty()){
            Pair out = pq.poll();
            int currDist = out.distance;
            int node = out.node;
            for(int i = 0; i < adj.get(node).size(); i++){
                int edgeWeight = adj.get(node).get(i).distance;
                int adjNode = adj.get(node).get(i).node;
                if(currDist + edgeWeight < distance[adjNode]){
                    distance[adjNode] = currDist + edgeWeight;
                    pq.add(new Pair(distance[adjNode],adjNode));
                }
            }
        }
        return distance;
    }
}
