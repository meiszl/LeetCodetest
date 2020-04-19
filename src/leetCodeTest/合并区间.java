package leetCodeTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 合并区间 {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{8,10},{1,3},{2,6},{15,18}};
        int[][] merge = merge(intervals);
        for (int i = 0; i < merge.length; i++) {
            System.out.println("Arrays.toString(merge[i]) = " + Arrays.toString(merge[i]));
        }
    }

    /**
     * 对起点和终点分别进行排序，将起点和终点一一对应形成一个数组。
     * 如果没有overlap,返回当前起点和终点
     * 如果有overlap,判断以下条件
     * 找出最小的起点
     * 如果当前终点大于下一个数组的起点的时候，比较当前终点和下一个终点的大小，取为right
     * 返回结果[left][right]
     * @param intervals
     * @return
     */
    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][0];
        Arrays.sort(intervals,(c1,c2) -> {
            return c1[0] - c2[0];
        });
        List<int[]> res = new ArrayList();
        int i=0;
        while (i<intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i<intervals.length - 1 && intervals[i+1][0] <= right){
                i++;
                right = Math.max(right,intervals[i][1]);
            }
            res.add(new int[]{left,right});
            i++;
        }
        return res.toArray(new int[0][]);
    }
}
