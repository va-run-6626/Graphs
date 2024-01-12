package ProblemsUndirected;
import  java.util.*;
public class Prog1_NumberOfProvinces {
    public static void main(String[] args) {
        int[][] isConnected = {
                {1,0,0},
                {0,1,0},
                {0,1,1}
        };
        System.out.println("Number of provinces : " + numberOfProvinces(isConnected));
    }
    private static int numberOfProvinces(int[][] isConnected){
        boolean[] vis = new boolean[isConnected.length];
        Arrays.fill(vis,false);
        int count = 0;
        for(int i = 0; i < vis.length; i++){
            if(vis[i] == false){
                dfs(isConnected,vis,i);
                count++;
            }
        }
        return count;
    }
    private static void dfs(int[][] isConnected, boolean[] vis, int node){
        vis[node] = true;
        for(int i = 0; i < isConnected[node].length; i++){
            if(isConnected[node][i] == 1 && !vis[i]){
                dfs(isConnected,vis,i);
            }
        }
    }
}