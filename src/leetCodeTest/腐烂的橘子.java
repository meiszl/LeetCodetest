package leetCodeTest;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class 腐烂的橘子 {
    public static void main(String[] args) {
        int a[][] = new int[][]{{2,1,1},{0,1,1},{1,0,1}};
        int i = orangesRotting(a);
        System.out.println("i = " + i);
    }

    /**
     * 思路
     *
     * 观察到对于所有的腐烂橘子，其实它们在广度优先搜索上是等价于同一层的节点的。
     *
     * 假设这些腐烂橘子刚开始是新鲜的，而有一个腐烂橘子(我们令其为超级源点)会在下一秒把这些橘子都变腐烂，
     * 而这个腐烂橘子刚开始在的时间是 -1−1 ，那么按照广度优先搜索的算法，下一分钟也就是第 00 分钟的时候，
     * 这个腐烂橘子会把它们都变成腐烂橘子，然后继续向外拓展，所以其实这些腐烂橘子是同一层的节点。那么在广
     * 度优先搜索的时候，我们将这些腐烂橘子都放进队列里进行广度优先搜索即可，最后每个新鲜橘子被腐烂的最短时间
     * dis[x][y]dis[x][y] 其实是以这个超级源点的腐烂橘子为起点的广度优先搜索得到的结果。
     *
     * 为了确认是否所有新鲜橘子都被腐烂，可以记录一个变量 cntcnt 表示当前网格中的新鲜橘子数，
     * 广度优先搜索的时候如果有新鲜橘子被腐烂，则 cnt-=1 ，最后搜索结束时如果 cntcnt 大于 00 ，
     * 说明有新鲜橘子没被腐烂，返回 -1−1 ，否则返回所有新鲜橘子被腐烂的时间的最大值即可，
     * 也可以在广度优先搜索的过程中把已腐烂的新鲜橘子的值由 11 改为 22，最后看网格中是否由值为 11 即新鲜的橘子即可。
     *
     * @param grid
     * @return
     */
    // dr,dc 配合使用得到 grid[r][c] 上grid[r-1][c]左grid[r][c-1]下grid[r+1][c]右grid[r][c+1]的元素
    static int[] dr = new int[]{-1, 0, 1, 0};
    static int[] dc = new int[]{0, -1, 0, 1};

    public static int orangesRotting(int[][] grid) {
        // 获取二维数组的行数row 和 列数 column
        int R = grid.length, C = grid[0].length;

        // queue : all starting cells with rotten oranges
        Queue<Integer> queue = new ArrayDeque();
        Map<Integer, Integer> depth = new HashMap();
        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c)
                if (grid[r][c] == 2) {
                    int code = r * C + c;  // 转化为索引唯一的一维数组
                    queue.add(code); //存储腐烂橘子
                    depth.put(code, 0); //存储橘子变为腐烂时的时间,key为橘子的一维数组下标，value为变腐烂的时间
                }

        int ans = 0;
        while (!queue.isEmpty()) {
            int code = queue.remove();
            int r = code / C, c = code % C;
            for (int k = 0; k < 4; ++k) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (0 <= nr && nr < R && 0 <= nc && nc < C && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    int ncode = nr * C + nc;
                    queue.add(ncode);
                    // 计次的关键 元素 grid[r][c] 的上左下右元素得腐烂时间应该一致
                    depth.put(ncode, depth.get(code) + 1);
                    ans = depth.get(ncode);
                }
            }
        }

        //检查grid，此时的grid能被感染已经都腐烂了，此时还新鲜的橘子无法被感染
        for (int[] row: grid)
            for (int v: row)
                if (v == 1)
                    return -1;
        return ans;

    }

}
