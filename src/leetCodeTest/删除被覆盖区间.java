package leetCodeTest;

import java.util.Arrays;

public class 删除被覆盖区间 {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {3,10},
                {4,10},
                {5,11}};
        int i = removeCoveredIntervals(intervals);
        System.out.println("i = " + i);
    }

    /**
     * 暴力解法，按要求循环比较每一个二维数组中的元素
     * @param intervals
     * @return
     */
//    public static int removeCoveredIntervals(int[][] intervals) {
//        if (intervals.length == 0 && intervals.length == 1)
//            return 0;
//        int i,j,count = intervals.length;
//        for (i=0;i<intervals.length;i++){
//            for (j=0;j<intervals.length;j++){
//                if (i != j && intervals[j][0] != -1 && intervals[i][0] != -1){
//                    if (intervals[i][0] <= intervals[j][0] && intervals[j][1] <= intervals[i][1]){
//                        System.out.println("i = " + i);
//                        System.out.println("j = " + j);
//                        System.out.println("intervals[j] = " + Arrays.toString(intervals[j]));
//                        intervals[j][0] = -1;
//                        count--;
//                    }
//                }
//            }
//        }
//        return count;
//    }

    /**
     * 先根据每一组的第0位大小进行排序然后再进行比较，这样因为第一位大小已经确定所以可以省去一步判断，
     * 然后在从前往后进行比较第二位大小即可得到答案。
     * @param intervals
     * @return
     */
    public static int removeCoveredIntervals(int[][] intervals) {
        //(o1,o2) -> 是自定义Comparator
        Arrays.sort(intervals,((o1, o2) -> o1[0] == o2[0]? o2[1] - o1[1] : o1[0] - o2[0]));
        int count = intervals.length,res = count;
        //intervals[0][1] 即是目前的最小值（以及经过排序）
        int max = intervals[0][1];
        //从intervals[1][1]开始
        for (int i = 1; i < count; i++) {
            //判断这个区间是否会被覆盖
            if (intervals[i][1] <= max){
                res--;
            }else {
                max = Math.max(max,intervals[i][1]);
            }
        }
        return res;
  }
}
