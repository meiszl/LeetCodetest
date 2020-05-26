package leetCodeTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 最大矩形 {
    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        int i = maximalRectangle(matrix);
        System.out.println("i = " + i);
    }
    public static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0)return 0;
        int count = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1'){

                    dp[i][j] = j == 0?1:dp[i][j-1] + 1;

                    int width = dp[i][j];
                    for (int k = i; k >= 0; k--) {
                        width = Math.min(dp[k][j],width);
                        count = Math.max(count,width*(i-k+1));
                    }
                }
            }
        }
        return count;
    }

}
