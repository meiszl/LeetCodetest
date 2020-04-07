package leetCodeTest;

import java.util.Arrays;

public class 旋转矩阵 {
    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}};
        rotate(a);
        for (int[] a1:a){
            System.out.println(Arrays.toString(a1));
        }

    }
    public static void rotate(int[][] matrix) {
        int i,j,temp;
        for (i=0;i<matrix.length;i++){
            for (j=i;j<matrix[i].length;j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
            for (j=0;j<matrix[i].length/2;j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[i].length-j-1];
                matrix[i][matrix[i].length-j-1] = temp;
            }
        }
    }

}
