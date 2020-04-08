package leetCodeTest;

import java.util.Arrays;

public class 最大子序和 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,-2};
        int i = maxSubArray(nums);
        System.out.println("i = " + i);
    }

    /**
     * 传统的暴力搜索法，超时
     * @param nums
     * @return
     */
//    public static int maxSubArray(int[] nums) {
//        if (nums.length == 0)
//            return 0;
//        if (nums.length == 1)
//            return nums[0];
//        int i,j,temp = Integer.MIN_VALUE,len,count;
//        for (len = 1;len<=nums.length;len++){
//            for (i=0;i+len<=nums.length;i++){
//                count = 0;
//                for (j=i;j<i+len;j++){
//                    count += nums[j];
//                }
//                temp = Math.max(temp,count);
//            }
//        }
//        return temp;
//    }

    /**
     * 使用数组保存动态规划状态位的方法，
     * 由于每一位的最大序列和就是Math.max（sum[i-1] + nums[i],nums[i]），
     * 这个地方意思就是，如果当前位置的值大于前面的序列和那么就从当前位置
     * 作为序列头重新生成序列进行序列和判断（这样的话新的序列和就变成了nums[i]）。
     * @param nums
     * @return
     */
//    public static int maxSubArray(int[] nums) {
//        if (nums.length == 0)
//            return 0;
//        if (nums.length == 1)
//            return nums[0];
//        int i,temp = nums[0];
//        int[] sum = new int[nums.length];
//        sum[0] = nums[0];
//        for (i=1;i<nums.length;i++){
//            sum[i] = Math.max(sum[i-1] + nums[i],nums[i]);
//            temp = Math.max(temp,sum[i]);
//        }
//        return temp;
//    }

    /**
     * Math.max(coun + nums[i],nums[i]);
     * 延伸思路：由于我们只用到了当前位置的nums值与之前
     * 位置的sum值所以我们不需要存储所有的sum值，我们只
     * 需要用一个变量存储前一位的sum值即可。
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int i,temp = nums[0],coun;
        coun = nums[0];
        for (i=1;i<nums.length;i++){
            coun = Math.max(coun + nums[i],nums[i]);
            temp = Math.max(temp,coun);
        }
        return temp;
    }
}
