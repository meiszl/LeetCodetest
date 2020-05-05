package leetCodeTest;

import java.util.Arrays;
import java.util.HashSet;

public class 最长连续序列 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,1};
        int i = longestConsecutive(nums);
        System.out.println("i = " + i);
    }

    /**
     * 先排序在进行判断。
     * @param nums
     * @return
     */
//    public static int longestConsecutive(int[] nums) {
//        if (nums == null || nums.length == 0) return 0;
//        Arrays.sort(nums);
//        System.out.println("Arrays.toString(nums) = " + Arrays.toString(nums));
//        int conum = nums[0];
//        int leng = 1,temlen = 1;
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] == conum){
//                continue;
//            }
//            if ((nums[i] - 1) == conum){
//                temlen++;
//                conum = nums[i];
//            }else {
//                temlen = 1;
//                conum = nums[i];
//            }
//            leng = Math.max(leng,temlen);
//        }
//        return leng;
//    }

    /**
     * Hash表法，O(n)
     * @param nums
     * @return
     */
    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }
        int res = 0;
        for (Integer num: hashSet) {
            if (!hashSet.contains(num - 1)){
                int leng = 1;
                int temnum = num;
                while (hashSet.contains(temnum + 1)){
                    temnum++;
                    leng++;
                }
                res = Math.max(res,leng);
            }
        }
        return res;
    }
}
