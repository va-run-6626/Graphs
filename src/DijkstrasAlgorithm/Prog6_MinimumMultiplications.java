package DijkstrasAlgorithm;

import java.util.*;

public class Prog6_MinimumMultiplications {
    public static final int MOD = 100000;
    public static class Pair{
        int node;
        int num;
        public Pair(int node, int num){
            this.node= node;
            this.num = num;
        }
    }
    public static void main(String[] args) {
        int[] arr = {2, 5, 7};
        int start = 3;
        int end = 30;

        int minimumMultiplications = solve(arr,start,end);
        System.out.println("Minimum Multiplications : "+minimumMultiplications);
    }

    private static int solve(int[] arr, int start, int end) {
        int[] nodeDistances = new int[MOD];
        PriorityQueue<Pair> queue = new PriorityQueue<>((a,b) -> a.num - b.num);
        Arrays.fill(nodeDistances, Integer.MAX_VALUE);
        nodeDistances[start] = 0;
        queue.add(new Pair(start,0));
        while (!queue.isEmpty()){
            Pair out = queue.poll();
            int node = out.node;
            int num = out.num;
            for(int i = 0; i < arr.length; i++){
                int newNode = (node * arr[i])%MOD;
                if(nodeDistances[newNode] > num+1){
                    nodeDistances[newNode] = num+1;
                    queue.add(new Pair(newNode,num+1));
                }
            }
        }
        if(nodeDistances[end] == Integer.MAX_VALUE) return -1;
        else return nodeDistances[end];
    }

}
