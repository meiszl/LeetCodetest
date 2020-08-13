package leetCodeTest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 岛屿数量 {
    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1','1','1','1','0'},
                                    {'1','1','0','0','0'},
                                    {'1','1','0','1','0'},
                                    {'0','0','1','1','1'}};
        int i = numIslands(grid);
        System.out.println("i = " + i);
    }

    /**
     * 并查集，
     * 首先记录所有值为1的位置的总数为count。
     * 将等于一的位置指向于最先遇到的一的位置，即如下所示集合
     * 1 1 0
     * 1 0 0
     * 0 1 1
     * 则有以下指向,
     * 1 ← 1 0
     *↑
     * 1 0 0
     * 0 1 ← 1
     * 然后每多出一次指向就减少一次count值即可，当遍历时遇到0则不减少count，
     * 所以最后的count值就是所得结果。
     */
//    static class UnionFind {
//            int count;
//            //表示指向的数组，每一位的值表示当前位指向哪个位置（初始时都指向自己）
//            //该数组经过拉伸处理，即将原数组从左上横向遍历到右下每个值分别存入该数组，
//            // 形成新的一行数组（就是将原来的二维数组按照横纵坐标转换为一维数组。方便之后存储指向位置）
//            int[] parent;
//            //表示根节点的数组，
//            // 即标识每一组指向的节点（当某一位置的值为一的时候表示该位置是一个根节点）
//            int[] rank;
//
//            public UnionFind(char[][] grid) {
//                count = 0;
//                int m = grid.length;
//                int n = grid[0].length;
//                parent = new int[m * n];
//                rank = new int[m * n];
//                for (int i = 0; i < m; ++i) {
//                    for (int j = 0; j < n; ++j) {
//                        if (grid[i][j] == '1') {
//                            parent[i * n + j] = i * n + j;
//                            ++count;
//                        }
//                        rank[i * n + j] = 0;
//                    }
//                }
//            }
//
//            public int find(int i) {
//                if (parent[i] != i) parent[i] = find(parent[i]);
//                return parent[i];
//            }
//
//            public void union(int x, int y) {
//                int rootx = find(x);
//                int rooty = find(y);
//                if (rootx != rooty) {
//                    if (rank[rootx] > rank[rooty]) {
//                        parent[rooty] = rootx;
//                    } else if (rank[rootx] < rank[rooty]) {
//                        parent[rootx] = rooty;
//                    } else {
//                        parent[rooty] = rootx;
//                        rank[rootx] += 1;
//                    }
//                    --count;
//                }
//            }
//
//            public int getCount() {
//                return count;
//            }
//        }
//
//        public static int numIslands(char[][] grid) {
//            if (grid == null || grid.length == 0) {
//                return 0;
//            }
//
//            int nr = grid.length;
//            int nc = grid[0].length;
//            UnionFind uf = new UnionFind(grid);
//            System.out.println(Arrays.toString(uf.parent));
//            System.out.println(Arrays.toString(uf.rank));
//            for (int r = 0; r < nr; ++r) {
//                for (int c = 0; c < nc; ++c) {
//                    if (grid[r][c] == '1') {
//                        grid[r][c] = '0';
//                        if (r - 1 >= 0 && grid[r-1][c] == '1') {
//                            uf.union(r * nc + c, (r-1) * nc + c);
//                        }
//                        if (r + 1 < nr && grid[r+1][c] == '1') {
//                            uf.union(r * nc + c, (r+1) * nc + c);
//                        }
//                        if (c - 1 >= 0 && grid[r][c-1] == '1') {
//                            uf.union(r * nc + c, r * nc + c - 1);
//                        }
//                        if (c + 1 < nc && grid[r][c+1] == '1') {
//                            uf.union(r * nc + c, r * nc + c + 1);
//                        }
//                    }
//                }
//            }
//            System.out.println(Arrays.toString(uf.parent));
//            System.out.println(Arrays.toString(uf.rank));
//            return uf.getCount();
//        }

    /**
     * 传统的bfs算法
     * @param grid
     * @return
     */
//    private static int result = 0;
//    private static int m;
//    private static int n;
//    public static int numIslands(char[][] grid) {
//        if (grid == null || grid.length == 0 || grid[0].length == 0)
//            return 0;
//        int i,j;
//        m = grid.length;
//        n = grid[0].length;
//        for (i=0;i<m;i++){
//            for (j=0;j<n;j++){
//                if (grid[i][j] == '0') continue;
//                dfs(grid,i,j);
//                result++;
//            }
//        }
//        return result;
//    }
//    public static void dfs(char[][] grid,int i, int j){
//        if (i < 0 || j < 0 || i >= m || j >= m) return;
//        if (grid[i][j] == '0') return;
//        grid[i][j] = '0';
//        dfs(grid, i-1, j);
//        dfs(grid, i+1, j);
//        dfs(grid, i, j-1);
//        dfs(grid, i, j+1);
//
//    }

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;

        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    grid[r][c] = '0';
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(r * nc + c);
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.remove();
                        int row = id / nc;
                        int col = id % nc;
                        if (row - 1 >= 0 && grid[row-1][col] == '1') {
                            neighbors.add((row-1) * nc + col);
                            grid[row-1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row+1][col] == '1') {
                            neighbors.add((row+1) * nc + col);
                            grid[row+1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col-1] == '1') {
                            neighbors.add(row * nc + col-1);
                            grid[row][col-1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col+1] == '1') {
                            neighbors.add(row * nc + col+1);
                            grid[row][col+1] = '0';
                        }
                    }
                }
            }
        }

        return num_islands;
    }
}
