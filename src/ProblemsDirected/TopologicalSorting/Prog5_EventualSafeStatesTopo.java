package ProblemsDirected.TopologicalSorting;

import java.util.*;

public class Prog5_EventualSafeStatesTopo {
        public static void main(String[] args) {
            int[][] edges = {
                    {0,1},
                    {1,2},
                    {2,3},
                    {2,4},
                    {3,4},
                    {3,5},
                    {4,6},
                    {5,6},
                    {6,7},
                    {8,1},
                    {8,9},
                    {9,10},
                    {10,8},
                    {11,9}
            };
            int nodes = 12;
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i <= nodes; i++){
                adj.add(new ArrayList<>());
            }
            for(int[] a : edges){
                adj.get(a[0]).add(a[1]);
            }
            List<Integer> ans = solve(nodes, adj);
            System.out.println(ans);
    }

    private static List<Integer> solve(int nodes, ArrayList<ArrayList<Integer>> adj) {
        List<List<Integer>> revAdj = new ArrayList<>();
        for(int i = 0; i < nodes; i++){
            revAdj.add(new ArrayList<>());
        }
        for(int i = 0; i < adj.size(); i++){
            for(Integer j : adj.get(i)){
                revAdj.get(j).add(i);
            }
        }
        int[] inDegree = new int[nodes];
        for(List<Integer> list : revAdj){
            for (Integer i : list){
                inDegree[i]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i< inDegree.length; i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()){
            Integer out = queue.poll();
            ans.add(out);
            for(Integer i : revAdj.get(out)){
                inDegree[i]--;
                if(inDegree[i] == 0){
                    queue.add(i);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
