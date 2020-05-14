package leetCodeTest;

import java.util.*;

public class 矩阵置零 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{2,3,5,3,3,4,5,1,2,3,7,2,4,2},
                {8,3,7,2,9,9,4,4,9,8,8,6,6,3},{9,4,4,1,9,9,7,2,5,4,3,7,2,4},{4,4,4,8,4,4,8,5,8,9,9,4,3,8},{3,8,6,6,7,8,9,1,4,3,3,3,9,7},{5,4,5,2,8,4,7,8,8,7,1,5,7,3},{6,3,9,5,4,8,7,8,4,3,8,9,1,8},{9,8,9,8,5,1,7,8,8,9,4,5,2,0},{2,6,4,2,3,3,8,5,9,2,3,8,4,9},{2,4,8,2,3,8,8,6,8,6,4,7,3,9},{9,6,8,4,1,7,1,5,9,5,6,3,9,7},{5,3,5,5,1,3,2,6,1,7,5,3,9,2},{4,7,6,5,4,8,6,5,6,7,9,7,5,5}};
//                {
////                {1,1,1},
////                {1,0,1},
////                {1,1,1}
////                {0,1,2,0},
////                {3,4,5,2},
////                {1,3,1,5}
//        };
        setZeroes(matrix);
        for (int[] ints : matrix) {
            System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));
        }
    }

    /**
     * 先找0，然后清空
     * @param matrix
     */
//    public static void setZeroes(int[][] matrix) {
//        if (matrix != null && matrix.length != 0 && matrix[0].length != 0){
//            //空间复杂度超限。
//            List<int[]> list = new ArrayList<>();
//            //bfs，时间较慢
////            boolean[][] flag = new boolean[matrix.length][matrix[0].length];
////            Queue<int[]> queue = new LinkedList<>();
////            queue.add(new int[]{0,0});
////            while (!queue.isEmpty()){
////                int[] poll = queue.poll();
////                flag[poll[0]][poll[1]] = true;
////                if (matrix[poll[0]][poll[1]] == 0)
////                    list.add(new int[]{poll[0],poll[1]});
////                if (poll[0] + 1 < matrix.length && !flag[poll[0] + 1][poll[1]])
////                    queue.offer(new int[]{poll[0] + 1,poll[1]});
////                if (poll[1] + 1 < matrix[0].length && !flag[poll[0]][poll[1] + 1])
////                    queue.offer(new int[]{poll[0],poll[1] + 1});
////            }
//            //直接遍历法，速度较快。空间复杂度O(m+n)超限
//            for (int i = 0; i < matrix.length; i++) {
//                for (int i1 = 0; i1 < matrix[i].length; i1++) {
//                    if (matrix[i][i1] == 0)
//                        list.add(new int[]{i,i1});
//                }
//            }
//            for (int[] ints : list) {
//                Arrays.fill(matrix[ints[0]],0);
//                for (int i = 0; i < matrix.length; i++) {
//                    matrix[i][ints[1]] = 0;
//                }
//            }
//        }
//    }

    /**
     * 2遍遍历，空间复杂度O(1),使用第一行第一列进行标志位存储。
     * @param matrix
     */
    public static void setZeroes(int[][] matrix) {
        boolean col0_flag = false;
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) col0_flag = true;
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col0_flag) matrix[i][0] = 0;
        }
    }
}
