package Problems;

import java.util.*;

public class Prog2_NumberOfIslands{
    public static void main(String[] args) {
        char[][] matrix = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println("Number of islands : "+ solve(matrix));
    }
    public static class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private static int solve(char[][] grid){
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        for(boolean[] a : vis){
            Arrays.fill(a,false);
        }
        Queue<Pair> queue = new LinkedList<>();
        int[] xDir = {0,-1,0,1};
        int[] yDir = {-1,0,1,0};
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '0'){
                    continue;
                }
                if(vis[i][j] == false) {
                    queue.add(new Pair(i, j));
                    vis[i][j] = true;
                    while (!queue.isEmpty()) {
                        Pair p = queue.poll();
                        int R = p.x;
                        int C = p.y;
                        for (int k = 0; k < 4; k++) {
                            int r = R + xDir[k];
                            int c = C + yDir[k];
                            if ((r >= 0 && r <= grid.length - 1) && (c >= 0 && c <= grid[0].length - 1) && (grid[r][c] == '1') && (vis[r][c] == false)) {
                                queue.add(new Pair(r, c));
                                vis[r][c] = true;
                            }
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }
}