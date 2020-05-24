package leetCodeTest;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class 矩阵中的路径 {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        boolean exist = exist(board, word);
        System.out.println("exist = " + exist);
    }
    public static boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        int i,j;
        for(i=0;i<board.length;i++){
            for(j=0;j<board[i].length;j++){
                if (dfs(board,i,j,chars,0)) return true;
            }
        }
        return false;
    }
    public static boolean dfs(char[][] board,int i,int j,char[] word,int fla){
        if (i < 0||i>=board.length||j<0||j>=board[0].length||board[i][j] != word[fla])
            return false;
        if (fla == word.length - 1)
            return true;
        char c = board[i][j];
        board[i][j] = '/';
        boolean res =   dfs(board, i+1, j, word, fla+1)||dfs(board, i, j+1, word, fla+1)||
                        dfs(board, i-1, j, word, fla+1)||dfs(board, i, j-1, word, fla+1);
        board[i][j] = c;
        return res;
    }
}
