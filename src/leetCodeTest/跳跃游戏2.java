package leetCodeTest;

import java.util.Arrays;

public class 跳跃游戏2 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1};
        int jump = jump(nums);
        System.out.println("jump = " + jump);
    }

    /**
     * dp算法超时
     * @param nums
     * @return
     */
//    public static int jump(int[] nums) {
//        if (nums == null || nums.length <= 1) return 0;
//        int[] sum = new int[nums.length];
//        Arrays.fill(sum,Integer.MAX_VALUE);
//        sum[0] = 0;
//        for (int i = 1; i < nums.length; i++) {
//            for (int j = 0; j < i; j++) {
//                if (nums[j] + j >= i){
//                    sum[i] = Math.min(sum[i],sum[j] + 1);
//                    break;
//                }
//            }
//        }
//
//        return sum[nums.length - 1];
//    }

    /**
     * 贪心算法
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {
        int maxposi = 0;
        int step = 0;
        int end = 0;
        int i;
        for (i=0;i<nums.length - 1; i++){
            maxposi = Math.max(maxposi,i + nums[i]);
            if (i == end){
                end = maxposi;
                step++;
            }
        }
        return step;
    }
}
