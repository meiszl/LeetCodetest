package leetCodeTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 存在重复 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        final boolean b = containsDuplicate(nums);
        System.out.println("b = " + b);
    }
    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int i;
        for (i=1;i<nums.length;i++){
            if (nums[i] == nums[i-1])
                return true;
        }
        return false;
    }

}
