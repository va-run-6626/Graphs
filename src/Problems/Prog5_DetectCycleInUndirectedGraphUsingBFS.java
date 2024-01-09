package Problems;
import java.util.*;
public class Prog5_DetectCycleInUndirectedGraphUsingBFS {
    public static void main(String[] args) {
        int[][] edges = {
                {1,2},{2,5},{5,7},{7,6},{6,3},{3,1},{3,4}
        };
        int nodes = 7;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= nodes; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        System.out.println("Detected Cycle : " + detectCycle(nodes,adj));
    }
    public static class Pair{
        int node;
        int parent;
        public Pair(int node, int parent){
            this.node = node;
            this.parent = parent;
        }
    }
    private static boolean detectCycle(int nodes, List<List<Integer>> adj){
        boolean[] vis = new boolean[nodes+1];
        Arrays.fill(vis,false);
        for(int i = 1; i < vis.length; i++){
            if(!vis[i]){
                if(checkForCycle(i,adj,vis)) return true;
            }
        }
        return false;
    }
    private static boolean checkForCycle(int src,List<List<Integer>> adj, boolean[] vis){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(src,-1));
        vis[src] = true;
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int node = p.node;
            int parent = p.parent;
            for(Integer i : adj.get(node)){
                if(!vis[i]){
                    vis[i] = true;
                    queue.add(new Pair(i,node));
                }else if(parent != i){
                    return true;
                }
            }
        }
        return false;
    }
}
