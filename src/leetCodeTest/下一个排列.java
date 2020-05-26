package leetCodeTest;

import java.util.Arrays;

public class 下一个排列 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,5};
        nextPermutation(nums);
        System.out.println("Arrays.toString(nums) = " + Arrays.toString(nums));
    }
    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int i = nums.length-2;
        while ( i >= 0 && nums[i+1] <= nums[i]) i--;
        if (i>=0){
            int j = nums.length-1;
            while (j >=0 && nums[j] <= nums[i]) j--;
            swap(nums,i,j);
        }
        reverse(nums,i+1);
    }
    public static void reverse(int[] nums,int start){
        int end = nums.length-1;
        while (start < end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }
    public static void swap(int[] nums,int i,int j){
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }
}
