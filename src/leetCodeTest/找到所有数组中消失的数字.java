package leetCodeTest;

import java.util.*;

public class 找到所有数组中消失的数字 {
    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        List<Integer> disappearedNumbers = findDisappearedNumbers(nums);
        System.out.println("disappearedNumbers = " + disappearedNumbers);
    }

    /**
     * hash表法
     * @param nums
     * @return
     */
//    public static List<Integer> findDisappearedNumbers(int[] nums) {
//        HashSet<Integer> hashSet = new HashSet<>();
//        int pre = 0;
//        List<Integer> res = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            hashSet.add(nums[i]);
//        }
//        for (int i = 1; i <= nums.length; i++) {
//            if (!hashSet.contains(i))
//                res.add(i);
//        }
//        return res;
//    }

    /**
     * 原地修改法
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0){
                nums[index] = -nums[index];
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i-1] > 0)
                res.add(i);
        }
        return res;
    }
}
