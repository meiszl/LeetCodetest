package leetCodeTest;

import java.util.ArrayDeque;
import java.util.Queue;

public class 地图分析 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,0,1},{0,0,0},{1,0,1}};
        int i = maxDistance(grid);
        System.out.println("i = " + i);
    }
    public static int maxDistance(int[][] grid) {
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        Queue<int[]> queue = new ArrayDeque();
        int m = grid.length,n = grid[0].length;
        int i,j;
        for (i=0;i<m;i++){
            for (j=0;j<n;j++){
                if (grid[i][j] == 1){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        boolean hasOcean = false;
        int[] point = null;
        while (!queue.isEmpty()){
            point = queue.poll();
            int x = point[0],y = point[1];
            for (i=0;i<4;i++){
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX <0|| newX >= m || newY < 0 || newY >= n || grid[newX][newY] != 0){
                    continue;
                }
                grid[newX][newY] = grid[x][y] + 1;
                hasOcean = true;
                queue.offer(new int[]{newX,newY});
            }
        }
        if (point == null || !hasOcean){
            return -1;
        }
        return grid[point[0]][point[1]] - 1;
    }
}
