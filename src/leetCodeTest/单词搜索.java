package leetCodeTest;

import java.util.*;

public class 单词搜索 {
    public static void main(String[] args) {
        /*
         */
        char[][] board = new char[][]{
//                {'A','B','C','E'},
//                {'S','F','C','S'},
//                {'A','D','E','E'}
//                {'a'}
                {'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'}
        };
        String word = "ABCESEEEF";
        单词搜索 d = new 单词搜索();
        boolean exist = d.exist(board, word);
        System.out.println("exist = " + exist);
    }
    /**
     * dfs+回溯，成功
     */
    private boolean[][] marked;

    private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    // 盘面上有多少行
    private int m;
    // 盘面上有多少列
    private int n;
    private String word;
    private char[][] board;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        if (m == 0) {
            return false;
        }
        n = board[0].length;
        marked = new boolean[m][n];
        this.word = word;
        this.board = board;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean dfs(int i, int j, int start) {
        if (start == word.length() - 1) {
            return board[i][j] == word.charAt(start);
        }
        if (board[i][j] == word.charAt(start)) {
            marked[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int newX = i + direction[k][0];
                int newY = j + direction[k][1];
                if (inArea(newX, newY) && !marked[newX][newY]) {
                    if (dfs(newX, newY, start + 1)) {
                        return true;
                    }
                }
            }
            marked[i][j] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
    /**
     * bfs存在问题。
     */
//    public boolean exist(char[][] board, String word) {
//        if (board.length == 0) {
//            return false;
//        }
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                if (board[i][j] == word.charAt(0)) {
//                    findAll()
//                }
//            }
//        }
//    }
//    public static boolean findAll(char[][] board,String word,int[] aim){
//        int fl = 1;
//        if (board != null&&board.length != 0&&board[0].length != 0){
//            Deque<int[]> deque = new LinkedList<>();
//            deque.addFirst(aim);
//            boolean[][] booleans = new boolean[board.length][board[0].length];
//            while (!deque.isEmpty()){
//                int size = deque.size();
//                for (int i = 0; i < size; i++) {
//                    int[] last = deque.pollLast();
//                    System.out.print(Arrays.toString(last) + " ");
//                    int x = last[0];
//                    int y = last[1];
//                    booleans[x][y] = true;
//                    if (fl < word.length()&&x+1<board.length&&!booleans[x+1][y]&&board[x+1][y] == word.charAt(fl)){
//                        deque.addFirst(new int[]{x+1,y});
//                    }
//                    if (fl < word.length()&&x-1>=0&&!booleans[x-1][y]&&board[x-1][y] == word.charAt(fl)){
//                        deque.addFirst(new int[]{x-1,y});
//                    }
//                    if (fl < word.length()&&y+1<board[0].length&&!booleans[x][y+1]&&board[x][y+1] == word.charAt(fl)){
//                        deque.addFirst(new int[]{x,y+1});
//                    }
//                    if (fl < word.length()&&y-1>=0&&!booleans[x][y-1]&&board[x][y-1] == word.charAt(fl)){
//                        deque.addFirst(new int[]{x,y-1});
//                    }
//                }
//                System.out.println();
//                if (!deque.isEmpty())
//                    fl++;
//            }
//        }
//        return fl == word.length();
//    }
}
