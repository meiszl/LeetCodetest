package leetCodeTest;

import java.util.Arrays;

public class 生命游戏 {
    public static void main(String[] args) {
        int[][] board = new int[][]{
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}
        };
        new 生命游戏().gameOfLife(board);
        int i;
        for (i=0;i<board.length;i++){
            System.out.println(Arrays.toString(board[i]));
        }
    }
    /**
     * 传统累计的方法，需要开辟新的二维数组去存储运算结果。
     * 首先计算每一位周围的1的个数，然后将1的个数输入统计的二维数组指定位置。
     * 最后得到统计值二维数组，遍历该数组，按要求更改board数组的值。
     */
//    public static void gameOfLife(int[][] board) {
//        int[][] num = new int[board.length][board[0].length];
//        int i,j;
//        for (i=0;i<board.length;i++){
//            for (j=0;j<board[i].length;j++){
//                num[i][j] = count(board, i, j);
//            }
//        }
//        for (i=0;i<board.length;i++){
//            for (j=0;j<board[i].length;j++){
//                if (board[i][j] == 1){
//                    if (num[i][j] < 2)
//                        board[i][j] = 0;
//                    if (num[i][j] == 2 || num[i][j] == 3)
//                        continue;
//                    if (num[i][j] > 3)
//                        board[i][j] = 0;
//                }else {
//                    if (num[i][j] == 3)
//                        board[i][j] = 1;
//                }
//            }
//        }
//    }
//    public static int count(int[][] board,int i,int j){
//        int[] Xi = {0,0,1,1,-1,-1,1,-1};
//        int[] Yj = {1,-1,1,-1,1,-1,0,0};
//        int len,count = 0;
//        for (len = 0;len<Xi.length;len++){
//            int numi = i + Xi[len];
//            int numj = j + Yj[len];
//            if (numi<0||numi>=board.length||numj<0||numj>=board[i].length)
//                continue;
//            if (board[numi][numj] == 1)
//                count++;
//        }
//        return count;
//    }
    /**
     * 不适用额外的存储空间。如果细胞从0变为1，则将其值置为2；
     * 如果细胞从1变为0，则将其值置为3。那么他们以模2取余后的值，即为原来的值。
     * 这样虽然数值改变了，并不影响计算其他细胞的更新。计算完成后，再将具有这些特殊状态的值还原为原有的值。
     *
     * 作者：ycoder
     * 链接：https://leetcode-cn.com/problems/game-of-life/solution/ding-yi-te-shu-zhuang-tai-by-ycoder/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private final int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1},{-1,1},{-1,-1},{1,1},{1,-1}};
    private int[][] board;

    public void gameOfLife(int[][] board) {
        this.board = board;
        int count = 0;
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[i].length; j ++) {
                count = aliveCount(i, j);
                if (board[i][j] == 1 && count < 2) {
                    board[i][j] = 3;
                }
                if (board[i][j] == 1 && (count == 2 || count == 3)) {
                    board[i][j] = 1;
                }
                if (board[i][j] == 1 && count > 3) {
                    board[i][j] = 3;
                }
                if (board[i][j] == 0 && count == 3) {
                    board[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[i].length; j ++) {
                if (board[i][j] < 2) continue;
                board[i][j] = (board[i][j] + 1) % 2;
            }
        }
    }

    private int aliveCount(int i, int j) {
        int x = 0, y = 0, count = 0;
        for (int k = 0; k < directions.length; k ++) {
            x = i + directions[k][0];
            y = j + directions[k][1];
            if (x >= 0 && x < board.length && y >= 0 && y < board[x].length) {
                count += board[x][y] % 2;
            }
        }
        return count;
    }

}
