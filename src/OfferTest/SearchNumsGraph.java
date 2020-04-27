package OfferTest;

import java.util.*;

public class SearchNumsGraph {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,1,1},{0,1,0},{1,0,0},{1,0,1}};
//        List<int[]> list = SearchAllByBFS(grid);
//        for (int[] ints : list) {
//        }
//        int i = NumberGridByBFS(grid);
//        System.out.println("i = " + i);
        int i1 = NumberGridByDFS(grid);
        System.out.println("i1 = " + i1);
    }
    public static int NumberGridByBFS(int[][] grid){
        int gridnums = 0;
        int i,j;
        if (grid != null){
            int[] fl = new int[]{0,1,0,-1};
            int[] fla = new int[]{1,0,-1,0};
            Queue<int[]> queue = new LinkedList();
            boolean[][] flag = new boolean[grid.length][grid[0].length];
            for (i=0;i<grid.length;i++){
                for (j=0;j<grid[i].length;j++){
                    if (!flag[i][j] && grid[i][j] == 1){
                        queue.offer(new int[]{i,j});
                        gridnums++;
                        grid[i][j] = 0;
                        flag[i][j] = true;
                        while (!queue.isEmpty()){
                            int[] poll = queue.poll();
                            for (int k = 0; k < 4; k++) {
                                int i1 = poll[0] + fl[k];
                                int j1 = poll[1] + fla[k];
                                if (i1 < 0 || i1 >= grid.length || j1 < 0 || j1 >= grid[0].length)
                                    continue;
                                if (grid[i1][j1] == 1){
                                    grid[i1][j1] = 0;
                                    flag[i1][j1] = true;
                                    queue.offer(new int[]{i1,j1});
                                }
                            }
                        }
                    }
                }
            }
        }
        return gridnums;
    }
    public static List<int[]> SearchAllByBFS(int[][] grid){
        List<int[]> list = new ArrayList();
        if (grid != null){
            Queue<int[]> queue = new LinkedList();
            boolean[][] flag = new boolean[grid.length][grid[0].length];
            flag[0][0] = true;
            queue.offer(new int[]{0,0});
            int[] fl = new int[]{0,1,0,-1};
            int[] fla = new int[]{1,0,-1,0};
            while (!queue.isEmpty()){
                int[] poll = queue.poll();
                if (grid[poll[0]][poll[1]] == 1){
                    list.add(new int[]{poll[0],poll[1]});
                }
                for (int i = 0; i < 4; i++) {
                    int i1 = poll[0] + fl[i];
                    int j1 = poll[1] + fla[i];
                    if (i1 < 0 || j1<0 || i1 >= grid.length || j1 >= grid[0].length)
                        continue;
                    int[] ints = {i1, j1};
                    if (!flag[i1][j1]){
                        queue.offer(ints);
                        flag[i1][j1] = true;
                    }
                }
            }
        }
        return list;
    }
    private static boolean[][] flag;
    public static int NumberGridByDFS(int[][] grid){
        int i,j,gridnums = 0;
        flag = new boolean[grid.length][grid[0].length];
        for (i=0;i<grid.length;i++){
            for (j=0;j<grid[0].length;j++){
                if (grid[i][j] == 1){
                    gridnums++;
                    NumberGridByDFS(grid,i,j);
                }
            }
        }
        return gridnums;
    }
    public static void NumberGridByDFS(int[][] grid,int i,int j){
        if (i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j] == 0){
            return;
        }
        grid[i][j] = 0;
        NumberGridByDFS(grid,i+1,j);
        NumberGridByDFS(grid,i,j+1);
        NumberGridByDFS(grid,i-1,j);
        NumberGridByDFS(grid,i,j-1);
    }
}
