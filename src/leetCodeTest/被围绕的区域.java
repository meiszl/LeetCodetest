package leetCodeTest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 被围绕的区域 {
    public static void main(String[] args) {
        char[][] board = new char[][]{
//                {'O','O','O','O','O','O','O','O','X','O','O','O','O','O','X','O','O','O','O','O'},
//                {'O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O','O'},
//                {'X','O','O','X','O','X','O','O','O','O','X','O','O','X','O','O','O','O','O','O'},
//                {'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','X','X','O'},
//                {'O','X','X','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O'},
//                {'O','O','O','O','X','O','O','O','O','O','O','X','O','O','O','O','O','X','X','O'},
//                {'O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O','O'},
//                {'O','O','O','O','O','O','O','O','O','O','O','O','O','X','O','O','O','O','O','O'},
//                {'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','X','O'},
//                {'O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},
//                {'O','O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O'},
//                {'O','O','O','O','X','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O'},
//                {'O','O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O'},
//                {'X','O','O','O','O','O','O','O','O','X','X','O','O','O','O','O','O','O','O','O'},
//                {'O','O','O','O','O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O'},
//                {'O','O','O','O','X','O','O','O','O','O','O','O','O','X','O','O','O','O','O','X'},
//                {'O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','X','O','X','O','O'},
//                {'O','X','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},
//                {'O','O','O','O','O','O','O','O','X','X','O','O','O','X','O','O','X','O','O','X'},
//                {'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'}
//                {'X','X','X','X'},
//                {'X','O','O','X'},
//                {'X','X','O','X'},
//                {'X','O','X','X'}
//                {'X','O','X'},
//                {'O','X','O'},
//                {'X','O','X'}
        };
        solve(board);
        for (char[] chars : board) {
            System.out.println("Arrays.toString(chars) = " + Arrays.toString(chars));
        }
    }

    /**
     * bfs解法
     */
//    private static boolean[][] flag;
//    private static Queue<int[]> queue;
//    public static void solve(char[][] board) {
//        if (board == null||board.length <= 1||board[0].length<=1) return;
//        flag = new boolean[board.length][board[0].length];
//        queue = new LinkedList<>();
//        for (int i = 0; i < board.length; i++) {
//            if (board[i][0] == 'O')
//                queue.add(new int[]{i,0});
//            if (board[i][board[0].length - 1] == 'O')
//                queue.add(new int[]{i,board[0].length - 1});
//        }
//        for (int i = 0; i < board[0].length; i++) {
//            if (board[0][i] == 'O')
//                queue.add(new int[]{0,i});
//            if (board[board.length - 1][i] == 'O')
//                queue.add(new int[]{board.length - 1,i});
//        }
//        bfs(board);
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[i].length; j++) {
//                if (board[i][j] == 'O'&& !flag[i][j])
//                    board[i][j] = 'X';
//            }
//        }
//
//    }
//    public static void bfs(char[][] board){
//        if (board != null){
//            while (!queue.isEmpty()){
//                int[] poll = queue.poll();
//                int x = poll[0];
//                int y = poll[1];
//                flag[x][y] = true;
//                if (x+1<board.length&&board[x+1][y] != 'X'&&!flag[x+1][y])
//                    queue.offer(new int[]{x+1,y});
//                if (y+1<board[0].length&&board[x][y+1]!='X'&&!flag[x][y+1])
//                    queue.offer(new int[]{x,y+1});
//                if (x-1>=0&&board[x-1][y] != 'X'&& !flag[x-1][y])
//                    queue.offer(new int[]{x-1,y});
//                if (y-1>=0&&board[x][y-1]!='X'&&!flag[x][y-1])
//                    queue.offer(new int[]{x,y-1});
//            }
//        }
//    }
    /**
     * dfs解法
     */
    public static void solve(char[][] board) {
        if (board == null||board.length <= 1||board[0].length<=1) return;
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                dfs(board,i,0);
            }
            if (board[i][board[0].length - 1] == 'O')
                dfs(board,i,board[0].length - 1);
        }
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O'){
                dfs(board,0,i);
            }
            if (board[board.length - 1][i] == 'O')
                dfs(board,board.length - 1,i);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }
    public static void dfs(char[][] board,int i,int j){
        if (i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]=='X'||board[i][j] == '#')
            return;
        board[i][j] = '#';
        dfs(board, i+1, j);
        dfs(board, i-1, j);
        dfs(board, i, j+1);
        dfs(board, i, j-1);

    }
}
