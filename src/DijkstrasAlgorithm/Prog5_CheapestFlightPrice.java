package DijkstrasAlgorithm;

import java.util.*;

public class Prog5_CheapestFlightPrice {

    public static void main(String[] args) {
        int[][] flights = {
                {0,1,100},
                {1,2,100},
                {2,0,100},
                {1,3,600},
                {2,3,200}
        };
        int n = 4;
        int src = 0;
        int dest = 3;
        int k = 1;

        int cheapestFlight = new Solution().solve(n,flights,src,dest,k);
        System.out.println("Cheapest Flight : " + cheapestFlight);
    }
}
class PairAdj {
    int node;
    int cost;
    public PairAdj(int node, int cost){
        this.node = node;
        this.cost = cost;
    }
}

    class FlightInfo{
        int stops;
        int node;
        int dist;

        public FlightInfo(int stops, int node, int dist){
            this.stops = stops;
            this.node = node;
            this.dist = dist;
        }
    }
class Solution{
    public int solve(int n, int[][] flights, int src, int dest, int k) {
        List<List<PairAdj>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] a : flights){
            adj.get(a[0]).add(new PairAdj(a[1],a[2]));
        }
        Queue<FlightInfo> queue = new LinkedList<>();
        int[] distance = new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[src] = 0;
        queue.add(new FlightInfo(0,src,0));
        while (!queue.isEmpty()){
            FlightInfo out = queue.poll();
            int node = out.node;
            int dist = out.dist;
            int stops = out.stops;
            for(PairAdj adjNode : adj.get(node)){
                int currStop = stops+1;
                if(currStop <= k+1){
                    int currdist = dist + adjNode.cost;
                    if(currdist < distance[adjNode.node]){
                        distance[adjNode.node] = currdist;
                        queue.add(new FlightInfo(currStop, adjNode.node, currdist));
                    }
                }
            }
        }
        return distance[dest];
    }
}
