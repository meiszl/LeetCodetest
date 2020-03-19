package leetCodeTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 剔除数组中的重复项 {
    public static void main(String[] args) {
        int nums[] = new int[]{1,2,1};
        final int i = removeDuplicates(nums);
        System.out.println("i = " + i);
    }

    /**
     * 思路：先排序然后逐个比对交换。
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        System.out.println("nums = " + Arrays.toString(nums));
        int i,j = 1,temp = nums[0],coun = 1;
        for (i = 1;i<nums.length;i++){
            if (temp != nums[i]){
                temp = nums[i];
                nums[j] = nums[i];
                j++;
                coun++;
            }
        }
        return coun;
    }
}
