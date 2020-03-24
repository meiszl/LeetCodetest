package leetCodeTest;

import java.util.Arrays;

public class 按摩师 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,1,4,5,3,1,1,3};
        int massage = massage(nums);
        System.out.println(massage);
    }

    /**
     * 动态规划，利用动态规划方法寻找能与当前位置组成最大值的数，
     * 定义两个数组规划值数组（与nums数组长度相同并且值相同）与num数组
     * 从当前位置的n-1位向前寻找，
     * 寻找所有与当前位置的和大于当前位置规划值的数据，并将最大的和记录在当前位置，
     * 最后从规划数组中选取最大的规划值即为所求结果。
     * @param nums
     * @return
     */
    public static int massage(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int i,j;
        int[] time = new int[nums.length];
        for (i=0;i<nums.length;i++)
            time[i] = nums[i];
        for (i=1;i<nums.length;i++){
            int temp = nums[i];
            for (j=0;j<i-1;j++){
                if (nums[i] + time[j] > temp)
                    temp = nums[i] + time[j];
            }
            time[i] = temp;
        }
        j=0;
        for (i=0;i<time.length;i++){
            if (time[i]>j)
                j = time[i];
        }
        return j;
    }

}
