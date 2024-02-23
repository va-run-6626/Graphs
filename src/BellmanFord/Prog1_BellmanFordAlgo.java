package BellmanFord;

import java.util.ArrayList;
import java.util.Arrays;

public class Prog1_BellmanFordAlgo {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> edges= new ArrayList<>(){
            {
                add(new ArrayList<Integer>(Arrays.asList(3, 2, 6)));
                add(new ArrayList<Integer>(Arrays.asList(5, 3, 1)));
                add(new ArrayList<Integer>(Arrays.asList(0, 1, 5)));
                add(new ArrayList<Integer>(Arrays.asList(1, 5, -3)));
                add(new ArrayList<Integer>(Arrays.asList(1, 2, -2)));
                add(new ArrayList<Integer>(Arrays.asList(3, 4, -2)));
                add(new ArrayList<Integer>(Arrays.asList(2, 4, 3)));
            }
        };
        int src = 0;
        int nodes = 6;
        int[] distances = solution(nodes, edges, src);
        System.out.println(Arrays.toString(distances));
    }

    static int[] solution(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int[] distances = new int[V];
        Arrays.fill(distances,Integer.MAX_VALUE - 2000);
        distances[S] = 0;
        for(int i = 1; i < V; i++){
            for(ArrayList<Integer> edge : edges){
                if(distances[edge.get(0)] + edge.get(2)  < distances[edge.get(1)]){
                    distances[edge.get(1)] = distances[edge.get(0)] + edge.get(2);
                }
            }
        }
        if(checkCycle(distances, edges)){
            return new int[]{-1};
        }
        for(int i = 0 ; i < distances.length; i++){
            if(distances[i] > 500000){
                distances[i] = (int)1e8;
            }
        }
        return distances;
    }
    static boolean checkCycle(int[] distances, ArrayList<ArrayList<Integer>> edges){
        int[] copy = distances.clone();

        for(ArrayList<Integer> edge : edges){
            if(copy[edge.get(0)] + edge.get(2)  < copy[edge.get(1)]){
                copy[edge.get(1)] = copy[edge.get(0)] + edge.get(2);
            }
        }

        for(int i = 0; i < distances.length; i++){
            if(distances[i] != copy[i]){
                return true;
            }
        }
        return false;
    }

}
