package leetCodeTest;

import java.util.*;

public class 矩阵中的最长递增路径 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
//                {3,4,5},
//                {3,2,6},
//                {2,2,1}
                {9,9,4},
                {6,6,8},
                {2,1,1}
//                {1}
        } ;
        int i = longestIncreasingPath(matrix);
        System.out.println("i = " + i);
    }

    /**
     * 究极bfs大法，超时。
     * @param matrix
     * @return
     */
//    public static int longestIncreasingPath(int[][] matrix) {
//        int count = 0;
//        if (matrix != null || matrix.length != 0){
//            for (int i = 0; i < matrix.length; i++) {
//                for (int j = 0; j < matrix[0].length; j++) {
//                    Queue<int[]> queue = new LinkedList<>();
//                    HashSet<int[]> hashSet = new HashSet<>();
//                    int temp = 0;
//                    queue.add(new int[]{i,j});
//                    while (!queue.isEmpty()){
//                        int size = queue.size();
//                        temp++;
//                        for (int k = 0; k < size; k++) {
//                            int[] poll = queue.poll();
//                            hashSet.add(poll);
//                            int[] res1 = {poll[0], poll[1] + 1};
//                            int[] res2 = {poll[0] + 1, poll[1]};
//                            int[] res3 = {poll[0] - 1, poll[1]};
//                            int[] res4 = {poll[0], poll[1] - 1};
//                            if (!hashSet.contains(res1)&&poll[1] + 1<matrix[0].length&&matrix[poll[0]][poll[1]]<matrix[poll[0]][poll[1] + 1]){
//                                queue.offer(res1);
//                            }
//                            if (!hashSet.contains(res2)&&poll[0] + 1 < matrix.length&&matrix[poll[0]][poll[1]]<matrix[poll[0] + 1][poll[1]]){
//                                queue.offer(res2);
//                            }
//                            if (!hashSet.contains(res3)&&poll[0] - 1 >= 0&&matrix[poll[0]][poll[1]]<matrix[poll[0] - 1][poll[1]]){
//                                queue.offer(res3);
//                            }
//                            if (!hashSet.contains(res4)&&poll[1] - 1>=0&&matrix[poll[0]][poll[1]]<matrix[poll[0]][poll[1] - 1]){
//                                queue.offer(res4);
//                            }
//                        }
//                    }
//                    count = Math.max(count,temp);
//                }
//            }
//
//        }
//        return count;
//    }
    /**
     * dfs算法，超时
     */
//    public static int longestIncreasingPath(int[][] matrix) {
//        int len = 0;
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                len = Math.max(len,find(matrix, i, j, 1));
//            }
//        }
//        return len;
//    }
//    public static int find(int[][] matrix,int i,int j,int len){
//        if (i<0||i>=matrix.length||j<0||j>=matrix[0].length)
//            return len;
//        len++;
//        int len1 = 1;
//        int len2 = 1;
//        int len3 = 1;
//        int len4 = 1;
//        if (i+1<matrix.length&&matrix[i+1][j] > matrix[i][j]){
//           len1 = Math.max(len, find(matrix, i+1, j,len));
//        }
//        if (i-1>=0&&matrix[i-1][j] > matrix[i][j]){
//            len2 = Math.max(len, find(matrix, i-1, j,len));
//        }
//        if (j+1<matrix[0].length&&matrix[i][j+1] > matrix[i][j]){
//            len3 = Math.max(len,find(matrix, i, j+1,len));
//        }
//        if (j-1>=0&&matrix[i][j-1] > matrix[i][j]){
//            len4 = Math.max(len,find(matrix, i, j-1,len));
//        }
//        len = Math.max(Math.max(len1,len2),Math.max(len3,len4));
//        return len;
//    }

    /**
     * 记忆化 + bfs
     * @param matrix
     * @return
     */
//    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
//    private static int m, n;
//    public static int longestIncreasingPath(int[][] matrix) {
//        if (matrix.length == 0)return 0;
//        m = matrix.length;
//        n = matrix[0].length;
//        int[][] cache = new int[m][n];
//        int count = 0;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                count = Math.max(count,dfs(matrix,i,j,cache));
//            }
//        }
//
//        return count;
//    }
//    private static int dfs(int[][] matrix,int i,int j,int[][] cache){
//        if (cache[i][j] != 0) return cache[i][j];
//        for (int[] dir : dirs) {
//            int x = i + dir[0],y = j + dir[1];
//            if (0<=x&&x<m&&0<=y&&y<n&&matrix[x][y]>matrix[i][j]){
//                cache[i][j] = Math.max(cache[i][j],dfs(matrix,x,y,cache));
//            }
//        }
//        return ++cache[i][j];
//    }
    /**
     * 动态规划算法.
     * 首先将每一个点周围大于该点的点个数记录为dp数组，然后将该数组中为0的点入队，然后使用bfs的方法每次将队列中剩余元素全部取光，
     * 判断每一个元素周围有没有dp - 1等于0的点，如果有得话就将那个位置的dp-1，然后将那个点入队，再将hight+1.一直循环直到队列为空，
     * hight即为所求的最长深度信息。
     */
    // Topological Sort Based Solution
// An Alternative Solution
    private static final int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static int m, n;
    public static int longestIncreasingPath(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        // padding the matrix with zero as boundaries
        // assuming all positive integer, otherwise use INT_MIN as boundaries
        int[][] matrix = new int[m + 2][n + 2];
        for (int i = 0; i < m; ++i)
            System.arraycopy(grid[i], 0, matrix[i + 1], 1, n);

        // calculate outdegrees
        int[][] outdegree = new int[m + 2][n + 2];
        for (int i = 1; i <= m; ++i)
            for (int j = 1; j <= n; ++j)
                for (int[] d: dir)
                    if (matrix[i][j] < matrix[i + d[0]][j + d[1]])
                        outdegree[i][j]++;

        // find leaves who have zero out degree as the initial level
        n += 2;
        m += 2;
        List<int[]> leaves = new ArrayList<>();
        for (int i = 1; i < m - 1; ++i)
            for (int j = 1; j < n - 1; ++j)
                if (outdegree[i][j] == 0) leaves.add(new int[]{i, j});
        for (int[] ints : outdegree) {
            System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));
        }
        System.out.println();
        for (int[] leaf : leaves) {
            System.out.println("Arrays.toString(leaf) = " + Arrays.toString(leaf));
        }

        // remove leaves level by level in topological order
        int height = 0;
        while (!leaves.isEmpty()) {
            height++;
            List<int[]> newLeaves = new ArrayList<>();
            for (int[] node : leaves) {
                for (int[] d:dir) {
                    int x = node[0] + d[0], y = node[1] + d[1];
                    if (matrix[node[0]][node[1]] > matrix[x][y])
                        if (--outdegree[x][y] == 0)
                            newLeaves.add(new int[]{x, y});
                }
            }
            leaves = newLeaves;
        }
        return height;
    }
}
