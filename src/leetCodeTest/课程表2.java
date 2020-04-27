package leetCodeTest;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 课程表2 {
    public static void main(String[] args) {
        int[][] prerequisites = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        int numCourses = 4;
        int[] order = findOrder(numCourses, prerequisites);
        System.out.println("order = " + Arrays.toString(order));
    }

    /**
     * 广度优先算法，入度表法
     * @param numCourses
     * @param prerequisites
     * @return
     */
//    public static int[] findOrder(int numCourses, int[][] prerequisites) {
//        if (numCourses == 0 || prerequisites == null) return new int[0];
//        if (numCourses == 1 ) return new int[]{0};
//        List<List<Integer>> lists = new ArrayList();
//        int i;
//        int[] courses = new int[numCourses];
//        for (i = 0; i < numCourses; i++) {
//            lists.add(new ArrayList());
//        }
//        for (int[] prerequisite : prerequisites) {
//            courses[prerequisite[0]]++;
//            lists.get(prerequisite[1]).add(prerequisite[0]);
//        }
//        List<Integer> list = new ArrayList();
//        Queue<Integer> queue = new LinkedList();
//        for (int j = 0; j < numCourses; j++) {
//            if (courses[j] == 0) queue.offer(j);
//        }
//        while (!queue.isEmpty()){
//            Integer poll = queue.poll();
//            if (!list.contains(poll))
//                list.add(poll);
//            numCourses--;
//            for (Integer integer : lists.get(poll)) {
//                courses[integer]--;
//                if (courses[integer] == 0)queue.offer(integer);
//            }
//        }
//        if (numCourses == 0)
//            return list.stream().mapToInt(Integer::valueOf).toArray();
//        else
//            return new int[0];
////        int[][] res = new int[lists.size()][lists.get(0).size()];
////        Stream<int[]> stream = lists.stream().map(s -> s.stream().mapToInt(Integer::valueOf).toArray());
////        List<int[]> collect = stream.collect(Collectors.toList());
////        int[][] ints = collect.toArray(new int[collect.size()][]);
////        Arrays.stream(ints).forEach(s ->{
////            System.out.println("Arrays.toString(s) = " + Arrays.toString(s));
////        });
//    }
    /**
     * 深度优先算法，入度表法
     */
    private static Stack<Integer> res;
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null) return new int[0];
        if (numCourses == 1) return new int[]{0};
        res = new Stack();
        List<List<Integer>> lists = new ArrayList();
        int[] flag = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            lists.add(new ArrayList());
        }
        for (int[] prerequisite : prerequisites) {
            lists.get(prerequisite[1]).add(prerequisite[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(lists,flag,i)) return new int[0];
        }
        System.out.println(res);
        int[] res1 = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res1[i] = res.pop();
        }
        return res1;
    }

    private static boolean dfs(List<List<Integer>> lists, int[] flag, int i) {
        if (flag[i] == 1) return false;
        if (flag[i] == -1) return true;
        flag[i] = 1;
        for (Integer list : lists.get(i)) {
            if (!dfs(lists, flag, list)) return false;
        }
        flag[i] = -1;
        if (!res.contains(i))
            res.add(i);
        return true;
    }

}
