package leetCodeTest;

import java.util.*;

public class 数组中数字出现的次数 {
    public static void main(String[] args) {
        int[] nums = new int[]{4,1,4,6};
        int[] ints = singleNumbers(nums);
        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));
    }

    /**
     * 集合法
     * @param nums
     * @return
     */
//    public static int[] singleNumbers(int[] nums) {
//        if (nums == null || nums.length == 0) return new int[0];
//        HashSet<Integer> hashSet = new HashSet();
//        for (int i = 0; i < nums.length; i++) {
//            if (hashSet.contains(nums[i])){
//                hashSet.remove(nums[i]);
//            }else {
//                hashSet.add(nums[i]);
//            }
//        }
//        return hashSet.stream().mapToInt(Integer::valueOf).toArray();
//    }

    /**
     * 位运算法
     * @param nums
     * @return
     */
    public static int[] singleNumbers(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        int first = 1;
        while ((res&first)==0){
            first = first << 1;
        }
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i]&first)==0){
                result[0] ^= nums[i];
            }else {
                result[1] ^= nums[i];
            }
        }
        return result;
    }
}
