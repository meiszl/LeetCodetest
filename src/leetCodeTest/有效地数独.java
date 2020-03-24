package leetCodeTest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 有效地数独 {
    public static void main(String[] args) {
        char[][] a = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        boolean validSudoku = isValidSudoku(a);
        System.out.println("validSudoku = " + validSudoku);
    }

    /**
     * 使用三个map集合数组存储每个元素在数独范围（每行、每列、每3x3放歌）内出现的次数，
     * 最后查询所有的map集合数组中是否存在大于1的数，如果存在则此数独失效。
     * @param board
     * @return
     */
    public static boolean isValidSudoku(char[][] board) {
        // init data
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer> [] columns = new HashMap[9];
        HashMap<Integer, Integer> [] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }

        // validate a board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int)num;
                    int box_index = (i / 3 ) * 3 + j / 3;

                    // keep the current cell value
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

                    // check if this value has been already seen before
                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1)
                        return false;
                }
            }
        }

        return true;
    }

    /**
     * 使用set集合存储元素来判断是否重复，然后三种情况分开判断。
     * @param board
     * @return
     */
//    public static boolean isValidSudoku(char[][] board) {
//        int i,j;
//        Set<Character> set = new HashSet();
//        for (i=0;i<board.length;i++){
//            set.clear();
//            for (j=0;j<board[i].length;j++){
//                if (board[i][j] != '.' && set.contains(board[i][j]))
//                    return false;
//                if (board[i][j] != '.' && !set.contains(board[i][j])){
//                    set.add(board[i][j]);
//                }
//            }
//        }
//        set.clear();
//        for (j=0;j<board[0].length;j++){
//            set.clear();
//            for (i=0;i<board.length;i++){
//                if (board[i][j] != '.' && set.contains(board[i][j]))
//                    return false;
//                if (board[i][j] != '.' && !set.contains(board[i][j])){
//                    set.add(board[i][j]);
//                }
//            }
//        }
//        set.clear();
//        for (i=0;i<=6;i += 3){
//            for (j=0;j<=6;j += 3){
//                boolean findtruemath = findtruemath(i, j, board);
//                if (!findtruemath)
//                    return false;
//            }
//        }
//        return true;
//    }
//    public static boolean findtruemath(int a,int b , char[][] board) {
//        int i, j;
//        Set<Character> set = new HashSet();
//        for (i = a; i < a + 3; i++) {
//            for (j = b; j < b + 3; j++) {
//                if (board[i][j] != '.' && set.contains(board[i][j]))
//                    return false;
//                if (board[i][j] != '.' && !set.contains(board[i][j])) {
//                    set.add(board[i][j]);
//                }
//            }
//        }
//        return true;
//    }

}
