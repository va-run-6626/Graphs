package ProblemsUndirected;

import java.util.*;

public class Prog4_RottenOranges {
    public static void main(String[] args) {
        int[][] grid = {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };
        System.out.println("Time Required : " + solve(grid));
    }
    public static class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private static int solve(int[][] grid){
        Queue<Pair> queue = new LinkedList<>();
        int freshOranges = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1) freshOranges++;
                else if(grid[i][j] == 2) queue.add(new Pair(i,j));
            }
        }
        int[] xDir = {0,-1,0,1};
        int[] yDir = {-1,0,1,0};
        if(freshOranges == 0) return 0;
        int time = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                Pair p = queue.poll();
                int R = p.x;
                int C = p.y;
                for(int i = 0; i < 4; i++){
                    int r = R + xDir[i];
                    int c = C + yDir[i];
                    if((r >= 0 && r <= grid.length-1) && (c >=0 && c <= grid[0].length-1) && (grid[r][c] == 1)){
                        grid[r][c] = 2;
                        queue.add(new Pair(r,c));
                        freshOranges--;
                    }
                }
                size--;
            }
            time++;
        }
        if(freshOranges > 0) return -1;
        else return time-1;
    }
}