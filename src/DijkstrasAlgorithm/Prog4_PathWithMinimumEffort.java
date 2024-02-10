package DijkstrasAlgorithm;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Prog4_PathWithMinimumEffort {
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
                {1,2,2},
                {3,8,2},
                {5,3,5}
        };
        int minimumEffort = solve(matrix);
        System.out.println("Minimum Effort is : "+minimumEffort);
    }

    private static int solve(int[][] matrix) {
        int startRow = 0;
        int startCol = 0;

        int endRow = matrix.length-1;
        int endCol = matrix[0].length-1;

        PriorityQueue<DistanceInfo> pq = new PriorityQueue<>((a,b) -> a.distance - b.distance);
        int[][] distanceMatrix = new int[matrix.length][matrix[0].length];
        for(int[] a : distanceMatrix){
            Arrays.fill(a,Integer.MAX_VALUE);
        }
        distanceMatrix[startRow][startCol] = 0;
        pq.add(new DistanceInfo(distanceMatrix[startRow][startCol],startRow,startCol));

        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};

        while (!pq.isEmpty()){
            DistanceInfo out = pq.poll();
            int diff = out.distance;
            int row = out.row;
            int col = out.col;
            if(row == endRow && col == endCol) return diff;
            for(int i = 0; i < 4; i++){
                int nRow = row + dx[i];
                int nCol = col + dy[i];
                if((nRow >= 0 && nRow <= matrix.length-1) && (nCol >= 0 && nCol <= matrix[0].length-1)){
                    int newEffort = Math.max(diff,Math.abs(matrix[row][col] - matrix[nRow][nCol]));
                    if(newEffort < distanceMatrix[nRow][nCol]){
                        distanceMatrix[nRow][nCol] = newEffort;
                        pq.add(new DistanceInfo(newEffort,nRow,nCol));
                    }
                }
            }
        }
        return 0;
    }
}
