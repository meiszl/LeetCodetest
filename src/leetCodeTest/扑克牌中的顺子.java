package leetCodeTest;

import java.util.Arrays;
import java.util.HashSet;

public class 扑克牌中的顺子 {
    public static void main(String[] args) {
        int[] nums = {0,0,1,3,5};
        boolean straight = isStraight(nums);
        System.out.println("straight = " + straight);
    }
    public static boolean isStraight(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                max = Math.max(nums[i],max);
                min = Math.min(nums[i],min);
                if (!hashSet.add(nums[i]))
                    return false;
            }
        }
        return max - min < 5;
    }
}
