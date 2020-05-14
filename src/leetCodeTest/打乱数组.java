package leetCodeTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class 打乱数组 {
    public static void main(String[] args) {
        int[] nums = new int[]{};
        Solution solution = new Solution(nums);
        int[] shuffle = solution.shuffle();
        System.out.println("Arrays.toString() = " + Arrays.toString(shuffle));
        int[] reset = solution.reset();
        System.out.println("Arrays.toString(reset) = " + Arrays.toString(reset));
    }

}
class Solution {
    int[] nums;
    int[] renums;
    public Solution(int[] nums) {
        this.nums = new int[nums.length];
        this.renums = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return renums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        nums = new int[renums.length];
        Random random = new Random();
        boolean[] flag = new boolean[nums.length];
        int i,nu;
        for (i=0;i<nums.length;i++){
            do {
                nu = random.nextInt(nums.length);
                System.out.println("nu = " + nu);
            }while (flag[nu]);
            flag[nu] = true;
            nums[i] = renums[nu];
        }
        return nums;
    }
}