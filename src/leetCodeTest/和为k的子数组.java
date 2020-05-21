package leetCodeTest;

import java.util.Arrays;
import java.util.HashMap;

public class 和为k的子数组 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1,2,3};
        int k =3;
        int i = subarraySum(nums, k);
        System.out.println("i = " + i);
    }

    /**
     * 枚举法
     * @param nums
     * @param k
     * @return
     */
//    public static int subarraySum(int[] nums, int k) {
//        if (nums == null || nums.length == 0) return 0;
//        int count = 0;
//        for (int i = 1; i <= nums.length; i++) {
//            int tem = 0;
//            int co = 0;
//            for (int j = i; j <= nums.length; j++) {
//                tem += nums[j-1];
//                if (tem == k){
//                    co++;
//                }
//            }
//            count += co;
//        }
//        return count;
//    }

    /**
     * 哈希表优化
     * 详解：https://leetcode-cn.com/problems/subarray-sum-equals-k/solution/he-wei-kde-zi-shu-zu-by-leetcode-solution/
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum(int[] nums, int k) {
        int count = 0,pre = 0;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        hashMap.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (hashMap.containsKey(pre - k))
                count += hashMap.get(pre - k);
            hashMap.put(pre,hashMap.getOrDefault(pre,0) + 1);
        }
        return count;
    }

}
