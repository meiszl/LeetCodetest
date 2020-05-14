package leetCodeTest;

import java.util.Arrays;

public class 颜色分类 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,2,2,2,2,0,2,1,1,0};
        sortColors(nums);
        System.out.println("Arrays.toString(nums) = " + Arrays.toString(nums));
    }
    public static void sortColors(int[] nums) {
        int start = 0,end = nums.length - 1;
        int temp,i=0;
        /**
         * 需要考虑后面换过来的数的比较。
         */
        while (i<=end){
            if (nums[i] == 0){
                temp = nums[i];
                nums[i++] = nums[start];
                nums[start] = temp;
                start++;
            }else if (nums[i] == 2){
                temp = nums[i];
                nums[i] = nums[end];
                nums[end] = temp;
                end--;
            }else {
                i++;
            }

        }
    }
}
