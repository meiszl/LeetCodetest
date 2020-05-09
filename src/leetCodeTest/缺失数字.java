package leetCodeTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class 缺失数字 {
    public static void main(String[] args) {
        int[] nums = new int[]{0};
        int i = missingNumber(nums);
        System.out.println("i = " + i);
    }

    /**
     * 排序法
     * @param nums
     * @return
     */
//    public static int missingNumber(int[] nums) {
//        if (nums == null|| nums.length == 0) return 0;
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length + 1; i++) {
//            if (i == nums.length)
//                return nums.length;
//            if (nums[i] != i)
//                return i;
//        }
//        return 0;
//    }

    /**
     * hash法
     * @param nums
     * @return
     */
//    public static int missingNumber(int[] nums) {
//        if (nums == null|| nums.length == 0) return 0;
//        HashSet<Integer> hashSet = new HashSet<>();
//        for (int num : nums) {
//            hashSet.add(num);
//        }
//        for (int i = 0; i <= nums.length; i++) {
//            if (!hashSet.contains(i))
//                return i;
//        }
//        return 0;
//    }

    /**
     * 异或运算求解
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        int miss = nums.length;
        for (int i = 0; i < nums.length; i++) {
            miss ^= i^nums[i];
        }
        return miss;
    }
}
