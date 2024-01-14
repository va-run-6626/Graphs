package ProblemsDirected.TopologicalSorting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Prog3_DetectCycleInADirectedGraphUsingBFS_Topological {
    public static void main(String[] args) {
            int[][] edges = {
                    {2,3},
                    {1,2},
                    {3,4},
                    {4,5},
                    {5,6},
                    {3,7},
                    {7,5},
                    {8,2},
                    {8,9},
                    {9,10},
                    {10,8}
            };
            int nodes = 10;
            List<List<Integer>> adj = new ArrayList<>();
            for(int i = 0; i <= nodes; i++){
                adj.add(new ArrayList<>());
            }
            for(int[] a : edges){
                adj.get(a[0]).add(a[1]);
            }
            System.out.println("Cycle Detected : " + solve(nodes,adj));
    }

    private static boolean solve(int nodes, List<List<Integer>> adj) {
        int[] inDegree = new int[nodes+1];
        for(int i = 0; i <= nodes; i++){
            for(Integer a : adj.get(i)){
                inDegree[a]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < inDegree.length; i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }
        int cnt = 0;
        while (!queue.isEmpty()){
            int node = queue.poll();
            cnt++;
            for(Integer i : adj.get(node)){
                inDegree[i]--;
                if(inDegree[i] == 0){
                    queue.add(i);
                }
            }
        }
        return !(cnt == nodes);
    }
}
