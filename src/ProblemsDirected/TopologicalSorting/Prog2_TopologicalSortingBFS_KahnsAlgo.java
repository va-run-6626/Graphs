package ProblemsDirected.TopologicalSorting;

import java.util.*;

public class Prog2_TopologicalSortingBFS_KahnsAlgo {
    public static void main(String[] args) {
        int[][] edges = {
                {5,0},
                {5,2},
                {2,3},
                {4,0},
                {4,1},
                {3,1}
        };
        List<List<Integer>> adj = new ArrayList<>();
        int nodes = 6;
        for(int i = 0; i < nodes; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
        }
        System.out.println("Topological Sort linear ordering : "+ Arrays.toString(solve(nodes,adj)));
    }

    private static int[] solve(int nodes, List<List<Integer>> adj) {
        int[] inDegree = new int[nodes];
        for(int i = 0; i < nodes; i++){
            for(Integer a : adj.get(i)){
                inDegree[a]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int[] topo = new int[nodes];
        int i = 0;
        while (!queue.isEmpty()){
            int node = queue.poll();
            topo[i++] = node;
            for(Integer in : adj.get(node)){
                inDegree[in]--;
                if(inDegree[in] == 0){
                    queue.add(in);
                }
            }
        }
        return topo;
    }
}
