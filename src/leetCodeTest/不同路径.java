package leetCodeTest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 不同路径 {
    public static void main(String[] args) {
        int n = 12;
        int m = 23;
        int i = uniquePaths(m, n);
        System.out.println("i = " + i);
    }
    private static int count = 0;

    /**
     * 动态规划，每一个点存储到该点的路径数，路径数等于i-1,j与i,j-1之间的数量之和。
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        int[][] matrix = new int[n][m];
//        bfs(matrix);
//        dfs(matrix,0,0);
        Arrays.fill(matrix[0],1);
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][0] = 1;
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
            }
        }
        return matrix[matrix.length - 1][matrix[0].length - 1];
    }
    /**
     * 广度搜索法，超时
     */
    public static void bfs(int[][] matrix){
        if (matrix != null){
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0,0});
            while (!queue.isEmpty()){
                int[] poll = queue.poll();
                if (poll[0] == matrix.length-1&& poll[1] == matrix[0].length-1)
                    count++;
                if (poll[0] + 1 < matrix.length)
                    queue.offer(new int[]{poll[0]+1,poll[1]});
                if (poll[1] + 1 < matrix[0].length)
                    queue.offer(new int[]{poll[0],poll[1]+1});
            }
        }
    }

    /**
     * 深度优先搜索，超时
     * @param matrix
     * @param i
     * @param j
     */
    public static void dfs(int[][] matrix,int i,int j){
        if (i>=matrix.length||j>=matrix[0].length)
            return;
        if (i == matrix.length-1&& j==matrix[0].length-1)
            count++;
        dfs(matrix,i+1,j);
        dfs(matrix,i,j+1);
    }
}
