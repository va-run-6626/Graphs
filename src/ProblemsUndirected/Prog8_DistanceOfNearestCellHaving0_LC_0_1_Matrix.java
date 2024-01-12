package ProblemsUndirected;

import java.util.*;

public class Prog8_DistanceOfNearestCellHaving0_LC_0_1_Matrix {
    public static void main(String[] args) {
        int[][] mat = {
                {0,0,0},
                {0,1,0},
                {1,1,1}
        };
        System.out.println("Question : ");
        for(int[] i : mat){
            System.out.println(Arrays.toString(i));
        }
        System.out.println();
        System.out.println("Answer : ");
        int[][] ans = solve(mat);
        for(int[] i : ans){
            System.out.println(Arrays.toString(i));
        }
    }
    public static class distanceInfo{
        int x;
        int y;
        int distance;
        public distanceInfo(int x, int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    private static int[][] solve(int[][] mat) {
        boolean[][] vis = new boolean[mat.length][mat[0].length];
        int[][] distance = new int[mat.length][mat[0].length];
        Queue<distanceInfo> queue = new LinkedList<>();
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 0){
                    queue.add(new distanceInfo(i,j,0));
                    vis[i][j] = true;
                }
            }
        }
        int[] xDir = {0,-1,0,1};
        int[] yDir = {-1,0,1,0};
        while(!queue.isEmpty()){
            distanceInfo pop = queue.poll();
            int x = pop.x;
            int y = pop.y;
            int nearDistance = pop.distance;
            distance[x][y] = nearDistance;

            for(int i = 0; i < 4; i++){
                int nx = x + xDir[i];
                int ny = y + yDir[i];

                if((nx >= 0 && nx <= mat.length-1) && (ny >= 0 && ny <= mat[0].length-1) && (mat[nx][ny] == 1) && (!vis[nx][ny])){
                    queue.add(new distanceInfo(nx,ny,nearDistance+1));
                    vis[nx][ny] = true;
                }
            }
        }
        return distance;
    }
}
