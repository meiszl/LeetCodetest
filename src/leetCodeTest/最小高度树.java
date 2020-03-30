package leetCodeTest;

import java.util.*;

public class 最小高度树 {
    public static void main(String[] args) {
        int[][] edges = new int[][]{{1, 0}, {1, 2}, {1, 3}};
        int n = 4;
        List<Integer> minHeightTrees = findMinHeightTrees(4, edges);
        System.out.println(minHeightTrees);
    }

    /**
     * 广度优先搜索+入度数组统计
     * 此类问题首先考虑广度优先搜索，最终的连接所有节点的最小高度树必然为入度最大的节点组成。
     * 所以首先需要得到节点的入度数组，然后记录每个节点的邻接节点数组map<Integer,List<Integer>>
     * 最后将这些节点分别入队（首先入队入度为一的节点），然后进行筛选。
     * 将队中节点分别拿出，并将与其相连的节点入度均减一（标识删除此节点）.
     * 然后判断是否有节点入度变为1，如果变为1则重新入队，继续执行上述操作，
     * 直到得到最后一组入度为一的节点数组即为最小高度树（因为剩下的节点是入度最大的节点，
     * 如果存在最小高度树必然存在这些节点）
     * @param n
     * @param edges
     * @return
     */
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<Integer> res = new ArrayList();
        int i;
        //过滤特殊情况
        if (n<=2){
            for (i=0;i<n;i++){
                res.add(i);
            }
            return res;
        }
        int[] degree = new int[n];
        //记录节点的入度以及节点的邻接节点
        HashMap<Integer,ArrayList<Integer>> keymap = new HashMap();
        for (i=0;i<n;i++){
            keymap.put(i,new ArrayList());
        }
        for (int[] edge: edges){
            degree[edge[0]]++;
            degree[edge[1]]++;
            keymap.get(edge[0]).add(edge[1]);
            keymap.get(edge[1]).add(edge[0]);
        }
        //将入度为一的节点入队
        ArrayDeque<Integer> queue = new ArrayDeque();
        for (i=0;i<n;i++){
            if (degree[i] == 1)
                queue.offer(i);
        }
        while (!queue.isEmpty()){
            //刷新每次存储节点的数组用于存储新的数组
            res = new ArrayList<>();
            int size = queue.size();
            for (i=0;i<size;i++){
                int poll = queue.poll();
                res.add(poll);
                ArrayList<Integer> integers = keymap.get(poll);
                for (Integer integer: integers){
                    degree[integer]--;
                    if (degree[integer] == 1)
                        queue.offer(integer);
                }
            }
        }
        return res;
    }
}
