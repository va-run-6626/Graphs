package Problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Prog3_Floodfill {
    public static void main(String[] args) {
        int[][] img = {
                {0,0,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,0},
                {0,1,1,1,1,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,0}
        };
        int sr = 1;
        int sc = 1;
        int color = 2;
        System.out.println("before flood fill : ");
        img = solve(img,sr,sc,color);
        for(int[] a : img){
            System.out.println(Arrays.toString(a));
        }
        System.out.println("After flood fill : ");
        for(int[] a : img){
            System.out.println(Arrays.toString(a));
        }
    }
    public static class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private static int[][] solve(int[][] img,int sr,int sc, int color){
        boolean[][] vis = new boolean[img.length][img[0].length];
        int[] xDir = {0,-1,0,1};
        int[] yDir = {-1,0,1,0};
        int prevColor = img[sr][sc];
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(sr,sc));
        vis[sr][sc] = true;
        img[sr][sc] = color;
        while (!queue.isEmpty()){
            Pair p = queue.poll();
            int x = p.x;
            int y = p.y;
            for(int i = 0; i < 4; i++){
                int r = x + xDir[i];
                int c = y + yDir[i];
                if((r >= 0 && r <= img.length-1) && (c >= 0 && c <= img[0].length-1) && (img[r][c] == prevColor) && (vis[r][c] == false)){
                    queue.add(new Pair(r,c));
                    vis[r][c] = true;
                    img[r][c] = color;
                }
            }
        }
        return img;
    }
}