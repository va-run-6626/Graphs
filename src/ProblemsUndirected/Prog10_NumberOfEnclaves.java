package ProblemsUndirected;

import java.util.Arrays;

public class Prog10_NumberOfEnclaves {
    public static void main(String[] args) {
        int[][] grid = {
                {0,0,0,0},
                {1,0,1,0},
                {0,1,1,0},
                {0,0,0,0}
        };
        System.out.println("Number if enclaves : " + solve(grid));
    }
    private static int solve(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        for(boolean[] a : vis){
            Arrays.fill(a,false);
        }
        //0th row
        for(int j = 0; j < m; j++){
            if(!vis[0][j] && grid[0][j] == 1){
                dfs(0,j,vis,grid);
            }
        }
        //0th column
        for(int i = 0; i < n; i++){
            if(!vis[i][0] && grid[i][0] == 1){
                dfs(i,0,vis,grid);
            }
        }
        //n-1th row
        for(int j = 0; j < m; j++){
            if(!vis[n-1][j] && grid[n-1][j] == 1){
                dfs(n-1,j,vis,grid);
            }
        }
        //m-1th column
        for(int i = 0; i < n; i++){
            if(!vis[i][m-1] && grid[i][m-1] == 1){
                dfs(i,m-1,vis,grid);
            }
        }

        //compute
        int noOfEnlaves = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    noOfEnlaves++;
                }
            }
        }
        return noOfEnlaves;
    }

    private static void dfs(int i, int j, boolean[][] vis, int[][] grid) {
        vis[i][j] = true;
        int[] xDir = {0,-1,0,1};
        int[] yDir = {-1,0,1,0};
        for(int a = 0; a < 4; a++){
            int nx = i + xDir[a];
            int ny = j + yDir[a];
            if((nx >= 0 && nx <= grid.length-1) && (ny >= 0 && ny <= grid[0].length-1) && (grid[nx][ny] == 1) && (!vis[nx][ny])){
                dfs(nx,ny,vis,grid);
            }
        }
    }

}
