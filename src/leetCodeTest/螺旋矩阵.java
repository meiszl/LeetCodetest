package leetCodeTest;

import java.util.ArrayList;
import java.util.List;

public class 螺旋矩阵 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        List<Integer> list = spiralOrder(matrix);
        System.out.println("list = " + list);
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if(matrix.length == 0 || matrix[0].length == 0) return list;
        int len  = matrix.length*matrix[0].length;
        int[] fla = new int[]{0,1,0,-1};
        int[] flb = new int[]{1,0,-1,0};
        int i=0,flro = 0,flco = 0,di = 0;
        boolean[][] flag = new boolean[matrix.length][matrix[0].length];
        while (i<len){
            list.add(matrix[flro][flco]);
            flag[flro][flco] = true;
            int cr = flro + fla[di];
            int cc = flco + flb[di];
            if (0<=cr&&cr<matrix.length&&0<=cc&& cc < matrix[0].length&& !flag[cr][cc]){
                flro = cr;
                flco = cc;
            }else {
                di = (di + 1)%4;
                flro += fla[di];
                flco += flb[di];
            }
            i++;
        }
        return list;
    }
}
