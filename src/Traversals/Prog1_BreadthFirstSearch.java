package Traversals;

import java.util.*;

public class Prog1_BreadthFirstSearch {
    public static void main(String[] args) {
        int[][] edges = {
                 {1,2}
                ,{1,6}
                ,{2,3}
                ,{2,4}
                ,{6,7}
                ,{6,8}
                ,{3,10}
                ,{4,5}
                ,{7,5}
                ,{8,9}
        };
        int nodes = 10;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= nodes; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] i : edges){
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }
        System.out.println("BFS traversal : ");
        bfsTraversal(nodes,adj);
    }
    private static void bfsTraversal(int nodes, List<List<Integer>> adj){
        boolean[] vis = new boolean[nodes+1];
        Arrays.fill(vis,false);
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        vis[1] = true;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                Integer node = queue.poll();
                System.out.print(node +",");

                for(Integer i : adj.get(node)){
                    if(vis[i] == false){
                        vis[i] = true;
                        queue.add(i);
                    }
                }
                size--;
            }
            System.out.println();
        }
    }
}
