package ProblemsDirected.TopologicalSorting;

import java.util.*;

public class Prog5_CourseScheduleII {
    public static void main(String[] args) {
        int[][] edge = {
                {1,0},{2,0},{3,1},{3,2}
        };
        int nodes = 4;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < nodes; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e : edge){
            adj.get(e[1]).add(e[0]);
        }
        System.out.println("Is possible : "+ Arrays.toString(topo(nodes,adj)));
    }

    private static int[] topo(int nodes, List<List<Integer>> adj) {
        int[] inDegree = new int[nodes];
        for(List<Integer> list : adj){
            for(Integer i : list){
                inDegree[i]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] topoS = new int[nodes];
        Arrays.fill(topoS,-1);
        for(int i = 0; i < nodes; i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }
        int i = 0;
        while(!queue.isEmpty()){
            Integer out = queue.poll();
            topoS[i++] = out;
            for(Integer a : adj.get(out)){
                inDegree[a]--;
                if(inDegree[a] == 0){
                    queue.add(a);
                }
            }
        }
        for(i = 0; i < topoS.length; i++){
            if(topoS[i] == -1){
                return new int[0];
            }
        }
        return topoS;
    }
}
