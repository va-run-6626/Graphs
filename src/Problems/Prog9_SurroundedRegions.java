package Problems;

import java.util.Arrays;

public class Prog9_SurroundedRegions {
    public static void main(String[] args) {
        char[][] grid= {
                {'x','x','x','x','x'},
                {'x','o','o','x','o'},
                {'x','x','o','x','o'},
                {'x','o','x','o','x'},
                {'o','o','x','x','x'},
        };
        System.out.println("Given Matrix : ");
        for(char[] a : grid){
            System.out.println(Arrays.toString(a));
        }
        System.out.println();
        solve(grid);
        System.out.println("Flipped Matrix : ");
        for(char[] a : grid) {
            System.out.println(Arrays.toString(a));
        }
    }

    private static void solve(char[][] board) {
        boolean[][] vis = new boolean[board.length][board[0].length];
        // 0th row
        for(int j = 0; j < board[0].length; j++){
            if(!vis[0][j] && board[0][j] == 'o'){
                dfs(0,j,vis,board);
            }
        }
        // 0th column
        for(int i = 0; i < board.length; i++){
            if(!vis[i][0] && board[i][0] == 'o'){
                dfs(i,0,vis,board);
            }
        }
        //n-1th row
        for(int j = 0; j < board[0].length; j++){
            if(!vis[board.length-1][j] && board[board.length-1][j] == 'o'){
                dfs(board.length-1,j,vis,board);
            }
        }
        //n-1th row
        for(int i = 0; i < board.length; i++){
            if(!vis[i][board[0].length-1] && board[i][board[0].length-1] == 'o'){
                dfs(i,board[0].length-1,vis,board);
            }
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'o' && !vis[i][j]){
                    board[i][j] = 'x';
                }
            }
        }
    }

    private static void dfs(int i, int j, boolean[][] vis,char[][] board) {
        vis[i][j] = true;

        int[] xDir = {0,-1,0,1};
        int[] yDir = {-1,0,1,0};
        for(int a = 0; a < 4; a++){
            int nx = i + xDir[a];
            int ny = j + yDir[a];
            if((nx >= 0 && nx <= board.length-1) && (ny >= 0 && ny <= board[0].length-1) && (board[nx][ny] == 'o') && (!vis[nx][ny])){
                dfs(nx, ny,vis,board);
            }
        }
    }

}
