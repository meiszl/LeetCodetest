package leetCodeTest;

import java.util.Arrays;

public class 顺时针打印矩阵 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int[] ints = spiralOrder(matrix);
        System.out.println("ints = " + Arrays.toString(ints));
    }
    public static int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return new int[0];
        int len = matrix.length*matrix[0].length;
        boolean[][] flag = new boolean[matrix.length][matrix[0].length];
        int[] yfl = {1,0,-1,0};
        int[] xfl = {0,1,0,-1};
        int count = 0,fl = 0;
        int[] mafl = new int[2];
        int[] res = new int[matrix.length * matrix[0].length];
        while (count < len){
            int x = mafl[0];
            int y = mafl[1];
            res[count] = matrix[x][y];
            flag[x][y] = true;
            int newx = x + xfl[fl];
            int newy = y + yfl[fl];
            if (newx < 0 || newx >= matrix.length||newy < 0||newy >= matrix[0].length||flag[newx][newy]){
                fl = (fl+1)%4;
                newx = x + xfl[fl];
                newy = y + yfl[fl];
            }
            mafl[0] = newx;
            mafl[1] = newy;
            count++;
        }
        return res;
    }
}
