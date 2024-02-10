package DijkstrasAlgorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Prog3_ShortestPathInBinaryMaze {
    public static class DistanceInfo{
        int distance;
        int row;
        int col;
        public DistanceInfo(int distance, int row, int col){
            this.distance = distance;
            this.row = row;
            this.col = col;
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {1,1,1,1},
                {1,1,0,1},
                {1,1,1,1},
                {1,1,0,0},
                {1,0,0,0}
        };
        int startRow = 0;
        int startCol = 1;

        int destRow = 2;
        int destCol = 2;

        int distance = solve(matrix,startRow,startCol,destCol,destRow);
        System.out.println("Shortest Distance is : "+ distance);
    }

    private static int solve(int[][] matrix, int startRow, int startCol, int destCol, int destRow) {
        if(startRow == destRow && startCol == destCol) return 0;
        int[][] distanceMatrix = new int[matrix.length][matrix[0].length];
        Queue<DistanceInfo> queue = new LinkedList<>();
        for(int[] a : distanceMatrix){
            Arrays.fill(a,Integer.MAX_VALUE);
        }
        distanceMatrix[startRow][startCol] = 0;
        queue.add(new DistanceInfo(0,startRow,startCol));
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        while(!queue.isEmpty()){
            DistanceInfo out = queue.poll();
            int row = out.row;
            int col = out.col;
            int distance = out.distance;
            for(int i = 0; i < 4; i++){
                int nRow = row + dx[i];
                int nCol = col + dy[i];
                if((nRow >= 0 && nRow <= matrix.length-1) && (nCol >= 0 && nCol <= matrix[0].length-1) && (matrix[nRow][nCol] == 1)){
                    int currDist = distance+1;
                    if(distanceMatrix[nRow][nCol] > currDist){
                        distanceMatrix[nRow][nCol] = currDist;
                        if(nRow == destRow && nCol == destCol){
                            return distanceMatrix[nRow][nCol];
                        }
                        queue.add(new DistanceInfo(distanceMatrix[nRow][nCol],nRow,nCol));
                    }
                }
            }
        }
        return -1;
    }
}
