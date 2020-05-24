package leetCodeTest;

import java.util.Arrays;

public class 礼物的最大价值 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,2,3},
                {3,2,1},
        };
        int value = maxValue(grid);
        System.out.println("value = " + value);
    }

    /**
     * dfs超时
     */
//    private static int res;
//    public static int maxValue(int[][] grid) {
//        dfs(grid,0,0,0);
//        return res;
//    }
//    public static void dfs(int[][] grid,int i,int j,int count){
//        if (i<0||i>=grid.length||j<0||j>=grid[0].length)
//            return;
//        count += grid[i][j];
//        res = Math.max(res,count);
//        dfs(grid, i+1, j, count);
//        dfs(grid, i, j+1, count);
//    }

    /**
     * 动态规划
     * @param grid
     * @return
     */
    public static int maxValue(int[][] grid) {
        if (grid == null||grid.length == 0|| grid[0].length == 0) return 0;
        int[][] sum = new int[grid.length + 1][grid[0].length + 1];
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < sum.length; i++) {
            for (int j = 1; j < sum[0].length; j++) {
                sum[i][j] = Math.max(grid[i-1][j-1] + sum[i-1][j],grid[i-1][j-1] + sum[i][j-1]);
                res = Math.max(res,sum[i][j]);
            }
        }
        return res;
    }
}
