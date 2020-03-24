package leetCodeTest;

import java.util.Arrays;

public class 旋转图像 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}};
        rotate(matrix);
        int i;
        for (i=0;i<matrix.length;i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    /**
     * 首先转置矩阵然后将矩阵按中间一列切分成两部分将左边的那一部分与右边相交换即可，
     * 如此例，矩阵转置结果为：
     * [1, 4, 7]
     * [2, 5, 8]
     * [3, 6, 9]
     * 将左右两部分交换结果为
     * [7, 4, 1]
     * [8, 5, 2]
     * [9, 6, 3]
     * 即为旋转结果。
     * @param matrix
     */
    public static void rotate(int[][] matrix) {
        int i,j;
        int tmp;
        int n = matrix.length;
        for (i=0; i< n; i++){
            for (j=i; j< n; j++){
                tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for (i=0; i< n; i++){
            for (j=0; j< n /2; j++){
                tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = tmp;
            }
        }
    }
}
