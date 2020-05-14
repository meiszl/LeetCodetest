package leetCodeTest;

import java.util.Arrays;

public class 只出现一次的数字 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1};
        final int i = singleNumber(nums);
        System.out.println("i = " + i);
    }
    /**
     * 排序选择。
     */
//    public static int singleNumber(int[] nums) {
//        if (nums.length==1)
//            return nums[0];
//        Arrays.sort(nums);
//        int i;
//        int temp = 0;
//        for (i=1;i<nums.length;i++){
//            if (nums[i]!=nums[i-1]){
//                if (i==nums.length-1)
//                    temp = nums[i];
//                if (i!=nums.length-1 && nums[i]!=nums[i+1])
//                    temp = nums[i];
//                if (i-1 == 0)
//                    temp = nums[i-1];
//            }
//        }
//        return temp;
//    }

    /**
     * 位运算
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int tem = nums[0];
        for (int i = 1; i < nums.length; i++) {
            tem ^= nums[i];
        }
        return tem;
    }
}
