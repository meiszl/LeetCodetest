package leetCodeTest;

import java.util.Arrays;

public class 旋转数组 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2};
        int  k = 3;
        rotate(nums,k);
        System.out.println("nums = " + Arrays.toString(nums));
    }

    /**
     * 这个方法基于这个事实：当我们旋转数组 k 次， k\%n个尾部元素会被移动到头部，剩下的元素会被向后移动。
     *
     * 在这个方法中，我们首先将所有元素反转。然后反转前 k 个元素，再反转后面 n-k个元素，就能得到想要的结果。
     *
     * 假设 n=7 且 k=3。
     *
     * 原始数组                  : 1 2 3 4 5 6 7
     * 反转所有数字后             : 7 6 5 4 3 2 1
     * 反转前 k 个数字后          : 5 6 7 4 3 2 1
     * 反转后 n-k 个数字后        : 5 6 7 1 2 3 4 --> 结果
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    /**
     * 思路一：暴力置换法。
     * 构造新的数组，数组长度为原数组长度+k，然后按k后移最后再将数组后几位调换到前面，然后赋值给原数组。
     * @param nums
     * @param k
     */
//    public static void rotate(int[] nums, int k) {
//        int[] tem = new int[nums.length + k];
//        int i,j = 1;
//        for (i=0;i<nums.length;i++){
//            tem[i + k] = nums[i];
//        }
//        for (i = k-1;i>=0;i--){
//            tem[i] = tem[tem.length - j];
//            j++;
//        }
//        for (i = 0;i<nums.length;i++){
//            nums[i] = tem[i];
//        }
//    }
}
