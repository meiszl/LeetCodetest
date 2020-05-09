package leetCodeTest;

import java.util.Arrays;

public class 最大正方形 {
    public static void main(String[] args) {
        char[][] matrix = new char[][]{
//                {'1','0','1','0','0'},
//                {'1','0','1','1','1'},
//                {'1','1','1','1','1'},
//                {'1','0','0','1','0'}
                {'1'}
        };
        int i = maximalSquare(matrix);
        System.out.println("i = " + i);
    }

    /**
     * @param matrix
     * @return
     */
    public static int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0||matrix[0].length == 0) return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] sum = new int[n][m];
        int countres = 0;
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == '1')
                sum[i][0] = 1;
            else
                sum[i][0] = 0;
            countres = Math.max(countres,sum[i][0]);
        }
        for (int i = 0; i < m; i++) {
            if (matrix[0][i] == '1')
                sum[0][i] = 1;
            else
                sum[0][i] = 0;
            countres = Math.max(countres,sum[0][i]);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == '1')
                    sum[i][j] = Math.min(Math.min(sum[i-1][j],sum[i][j-1]),sum[i-1][j-1])+1;
                else
                    sum[i][j] = 0;
                countres = Math.max(countres,sum[i][j]);
            }
        }
        return countres*countres;
    }
}
