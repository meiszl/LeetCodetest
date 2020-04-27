package leetCodeTest;

import java.util.*;

public class 课程表 {
    public static void main(String[] args) {
        int numCoures = 2;
        int[][] prerequisites = new int[][]{{1,0},{0,1}};
        boolean b = canFinish(numCoures, prerequisites);
        System.out.println("b = " + b);
    }

    /**
     * 入度表（BFS法）
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] head = new int[numCourses];
        ArrayList<ArrayList<Integer>> list = new ArrayList();
        int i;
        for(i=0;i<numCourses;i++){
            list.add(new ArrayList());
        }
        for (int[] prerequisite : prerequisites) {
            head[prerequisite[0]]++;
            list.get(prerequisite[1]).add(prerequisite[0]);
        }
        Queue<Integer> queue = new LinkedList();
        for (i=0;i<numCourses;i++)
            if (head[i] == 0) queue.offer(i);
        while (!queue.isEmpty()){
            Integer poll = queue.poll();
            numCourses--;
            for (Integer integer : list.get(poll)) {
                head[integer]--;
                if (head[integer] == 0)
                    queue.offer(integer);
            }
        }
        System.out.println(Arrays.toString(head));
        return numCourses == 0;
    }

    /**
     * 深度优先搜索（入度表）
     * @param numCourses
     * @param prerequisites
     * @return
     */
//    public static boolean canFinish(int numCourses, int[][] prerequisites) {
//        List<List<Integer>> lists = new ArrayList();
//        for (int i = 0; i < numCourses; i++) {
//            lists.add(new ArrayList());
//        }
//        for (int[] prerequisite : prerequisites) {
//            lists.get(prerequisite[1]).add(prerequisite[0]);
//        }
//        int[] flag = new int[numCourses];
//        for (int i = 0; i < numCourses; i++) {
//            if (!dfs(lists,flag,i)) return false;
//        }
//        return true;
//    }
//
//    private static boolean dfs(List<List<Integer>> lists, int[] flag, int i) {
//        if (flag[i] == 1)return false;
//        if (flag[i] == -1) return true;
//        flag[i] = 1;
//        for (Integer integer : lists.get(i)) {
//            if (!dfs(lists,flag,integer)) return false;
//        }
//        flag[i] = -1;
//        return true;
//    }

}
