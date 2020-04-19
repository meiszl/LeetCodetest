package leetCodeTest;

import java.util.Arrays;

public class 跳跃游戏 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,0,0};
        boolean b = canJump(nums);
        System.out.println("b = " + b);
    }
    public static boolean canJump(int[] nums) {
        int i;
        int numslength = 0;
        for (i=0;i<nums.length;i++){
            if (i<= numslength){
                numslength = Math.max(numslength,i + nums[i]);
            }
            if (numslength >= nums.length - 1)
                return true;
        }
        return false;
    }
}
