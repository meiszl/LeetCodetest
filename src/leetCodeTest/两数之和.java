package leetCodeTest;

import java.util.Arrays;

public class 两数之和 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        int[] ints = twoSum(nums, target);
        System.out.println("ints = " + Arrays.toString(ints));
    }
    public static int[] twoSum(int[] nums, int target) {
        int i,j;
        int[] result = new int[2];
        for (i=0;i<nums.length;i++){
            int res = target - nums[i];
            int temp = i;
            for (j=0;j<nums.length;j++){
                if (nums[j] == res && j != temp){
                    result[0] = temp;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
}
