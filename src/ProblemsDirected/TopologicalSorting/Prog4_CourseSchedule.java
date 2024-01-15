package ProblemsDirected.TopologicalSorting;
import java.util.*;
public class Prog4_CourseSchedule {
    public static void main(String[] args) {
        int[][] edge = {
                {0,1}
        };
        int nodes = 2;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < nodes; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e : edge){
            adj.get(e[0]).add(e[1]);
        }
        System.out.println("Is possible : "+ topo(nodes,adj));
    }

    private static boolean topo(int nodes, List<List<Integer>> adj) {
        int[] inDegree = new int[nodes];
        for(List<Integer> list : adj){
            for(Integer a : list){
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
        while(!queue.isEmpty()){
            Integer out = queue.poll();
            cnt++;
            for(Integer i : adj.get(out)){
                inDegree[i]--;
                if(inDegree[i] == 0){
                    queue.add(i);
                }
            }
        }
        return cnt == nodes;
    }
}
