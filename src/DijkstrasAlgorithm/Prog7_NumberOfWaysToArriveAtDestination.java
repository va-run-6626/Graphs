package DijkstrasAlgorithm;

import java.util.*;

public class Prog7_NumberOfWaysToArriveAtDestination {
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {
                {0 ,1 ,1000000000},
                {0 ,3 ,1000000000},
                {1 ,3 ,1000000000},
                {1 ,2 ,1000000000},
                {1 ,5 ,1000000000},
                {3 ,4 ,1000000000},
                {4 ,5 ,1000000000},
                {2 ,5 ,1000000000}
        };
        List<List<Integer>> roads = new ArrayList<>();
        for(int[] edge : edges){
            List<Integer> list = new ArrayList<>();
            for(int i : edge){
                list.add(i);
            }
            roads.add(list);
        }
        int numberOfWays = solve(n,roads);
        System.out.println("Number of Ways to arrive at destination : " + numberOfWays);
    }

    private static int solve(int n, List<List<Integer>> roads) {
        double mod = 1e9 + 7;
        // Graph to store the roads.
        List<List<int[]>> graph = new ArrayList<>();

        // Initializing the graph ArrayList.
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // Adding the roads to the graph.
        for (List<Integer> road : roads) {
            graph.get(road.get(0)).add(new int[]{road.get(1), road.get(2)});
            graph.get(road.get(1)).add(new int[]{road.get(0), road.get(2)});
        }

        // Array to store the minimum distance from start node.
        long[] distance = new long[n];
        // Initializing the distance array with maximum values.
        Arrays.fill(distance, Long.MAX_VALUE);

        // Array to store the path count.
        int[] path = new int[n];

        // Priority queue for Dijkstra's algorithm.
        PriorityQueue<long[]> pq =
                new PriorityQueue<>((x, y)->{ return (int)x[0] - (int)y[0]; });

        // Adding the start node to priority queue.
        pq.add(new long[]{0, 0});
        // Setting the distance from start node to 0.
        distance[0] = 0;
        // Setting the path count for start node to 1.
        path[0] = 1;

        // Dijkstra's algorithm.
        while (!pq.isEmpty()) {
            long[] t = pq.poll();

            for (int[] nbr : graph.get((int)t[1])) {
                long vert = nbr[0];
                long edge = nbr[1];

                // Updating the distance and path count.
                if (distance[(int)vert] > distance[(int)t[1]] + edge) {
                    distance[(int)vert] = distance[(int)t[1]] + edge;
                    pq.add(new long[]{distance[(int)vert], vert});
                    path[(int)vert] = path[(int)t[1]] % 1000000007;
                } else if (distance[(int)vert] == t[0] + edge) {
                    path[(int)vert] += path[(int)t[1]];
                    path[(int)vert] %= 1000000007;
                }
            }
        }

        // Returning the path count for the last node.
        return path[n - 1];
    }
}
