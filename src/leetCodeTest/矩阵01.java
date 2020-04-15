package leetCodeTest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 矩阵01 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0,0,0},
                {0,1,0},
                {1,2,1}};
        int[][] ints = updateMatrix(matrix);
        for (int i = 0; i < ints.length; i++) {
            System.out.println("Arrays.toString(ints[i]) = " + Arrays.toString(ints[i]));
        }
    }

    /**
     * 广度优先搜索
     * @param matrix
     * @return
     */
    public static int[][] updateMatrix(int[][] matrix) {
        if (matrix == null||matrix.length == 0)return null;
        int m = matrix.length,n = matrix[0].length;
        int[][] res = new int[m][n];//结果集
        boolean[][] visited = new boolean[m][n];//记录已经计算过的位置
        Queue<int[]> queue = new LinkedList();//广搜队列
        //遍历，将等于0的位置计入结果集并入队
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0){
                    res[i][j] = 0;
                    visited[i][j] = true;
                    queue.offer(new int[]{i,j});
                }
            }
        }
        //四个方向的广搜
        int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            int i = poll[0],j = poll[1];
            //四个方向上找
            for (int k = 0; k < 4; k++) {
                int di = i + direction[k][0],dj = j + direction[k][1];
                //没有计算过的地方一定是1
                if (di >= 0 && di < m && dj >= 0 && dj < n && !visited[di][dj]){
                    res[di][dj] = res[i][j] + 1;
                    visited[di][dj] = true;
                    queue.offer(new int[]{di,dj});
                }
            }
        }
        return res;
    }

    /**
     * 使用DP方法简化搜索
     * @param matrix
     * @return
     */
//    public static int[][] updateMatrix(int[][] matrix) {
//        if (matrix == null || matrix.length == 0) return null;
//        int m = matrix.length,n = matrix[0].length;
//        int[][] dp = new int[m][n];
//        //初始化
//        for (int i = 0; i < m; i++) {
//            Arrays.fill(dp[i],10001);
//        }
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (matrix[i][j] == 0) dp[i][j] = 0;
//            }
//        }
//        //状态转移
//        //第一次填表从左上到右下
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (i-1 >= 0){
//                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j] + 1);
//                }
//                if (j-1 >= 0){
//                    dp[i][j] = Math.min(dp[i][j],dp[i][j-1] + 1);
//                }
//            }
//        }
//        //第二次填表从右下到左上
//        for (int i = m-1; i >= 0; i--) {
//            for (int j = n-1; j >= 0; j--) {
//                if (i+1 < m){
//                    dp[i][j] = Math.min(dp[i][j],dp[i+1][j] + 1);
//                }
//                if (j+1 < n){
//                    dp[i][j] = Math.min(dp[i][j],dp[i][j+1] + 1);
//                }
//            }
//        }
//        return dp;
//    }

    /**
     * 深度优先搜索
     */
//    static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
//
//    static int m;
//    static int n;
//    public static int[][] updateMatrix(int[][] matrix){
//        m = matrix.length;
//        if (m==0)
//            return matrix;
//        n = matrix[0].length;
//        //将周围没有0且为1的位置设置为一个极大值
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (matrix[i][j] == 1&&!hasNeighbors0(matrix,i,j))
//                    matrix[i][j]=Integer.MAX_VALUE;
//            }
//        }
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (matrix[i][j] == 1)
//                    dfs(matrix,i,j);
//            }
//        }
//        return matrix;
//    }
//    static boolean hasNeighbors0(int[][] matrix,int x,int y){
//        for (int[] dir:dirs){
//            int new_x = x + dir[0];
//            int new_y = y + dir[1];
//            if (new_x >= 0&&new_x<m&&new_y>=0&&new_y<n&&matrix[new_x][new_y]==0)
//                return true;
//        }
//        return false;
//    }
//    static void dfs(int[][] matrix,int x,int y){
//        for(int[] dir:dirs){
//            int new_x = x + dir[0];
//            int new_y = y + dir[1];
//            if (new_x>=0&&new_x<m&&new_y>=0&&new_y<n&&matrix[new_x][new_y] > matrix[x][y] + 1){
//                matrix[new_x][new_y] = matrix[x][y] + 1;
//                dfs(matrix,new_x,new_y);
//            }
//        }
//    }
}
