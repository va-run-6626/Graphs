package ProblemsUndirected;

import java.util.*;

public class Prog11_NumberOfDistinctIslands {
    public static void main(String[] args) {
        int[][] grid = {
                {1,1,0,1,1},
                {1,0,0,0,0},
                {0,0,1,1,1},
                {1,1,0,0,0}
        };
        System.out.println("Number of Distinct Islands :"+ solve(grid));
    }
    private static int solve(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Set<List<String>> set = new HashSet<>();
        boolean[][] vis = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!vis[i][j] && grid[i][j] == 1){
                    List<String> list = new ArrayList<>();
                    dfs(i,j,vis,grid,list,i,j);
                    set.add(list);
                }
            }
        }
        return set.size();
    }
    private static void dfs(int i,int j,boolean[][] vis,int[][] grid,List<String> list, int bx, int by){
        vis[i][j] = true;
        int dx = i-bx;
        int dy = j-by;
        String cal = "( "+dx+", "+dy+" )";
        list.add(cal);
        int n = grid.length;
        int m = grid[0].length;
        int[] xDir = {-1,0,1,0};
        int[] yDir = {0,-1,0,1};
        for(int a = 0; a < 4; a++){
            int nx = i + xDir[a];
            int ny = j + yDir[a];
            if((nx >= 0 && nx <= n-1) && (ny >= 0 && ny <= m-1) && (!vis[nx][ny]) && (grid[nx][ny] == 1)){
                dfs(nx,ny,vis,grid,list,bx,by);
            }
        }
    }
}
