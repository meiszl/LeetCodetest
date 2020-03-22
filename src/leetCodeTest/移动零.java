package leetCodeTest;

import java.util.Arrays;

public class 移动零 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
        System.out.println("Arrays.toString(nums) = " + Arrays.toString(nums));
    }

    /**
     * 循环迭代的将0向后放置，并且有几个0就需要迭代几次，每次只能将一个零放入到最后
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int i;
        int temp,count = 0;
        for (i=0;i<nums.length;i++){
            if (nums[i] ==0)
                count++;
        }
        while (count!=0){
            for (i=0;i<nums.length;i++){
                if (nums[i]==0 && i!=nums.length-1){
                    temp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = temp;
                }
            }
            count--;
        }

    }
}
