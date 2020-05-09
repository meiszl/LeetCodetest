package leetCodeTest;

import java.util.Arrays;

public class 除自身之外数组的乘积 {
    public static void main(String[] args) {
        int[] num = new int[]{1,2,3,4,5};
        int[] ints = productExceptSelf(num);
        System.out.println("ints = " + Arrays.toString(ints));
    }

    /**
     * 暴力方法，超时。
     * @param nums
     * @return
     */
//    public static int[] productExceptSelf(int[] nums) {
//        int[] res = new int[nums.length];
//        Arrays.fill(res,1);
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < nums.length; j++) {
//                if (j == i)
//                    continue;
//                if (nums[j] == 0){
//                    res[i] = 0;
//                    break;
//                }
//                res[i] *= nums[j];
//            }
//        }
//        return res;
//    }

    /**
     * 以索引为分割点，分别计算左右两侧的乘积即可得到答案。
     * 使用answer数组计算每一个左侧的乘积，然后遍历乘以分割点右侧。
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] answer = new int[len];
        answer[0] = 1;
        for (int i = 1; i < len; i++) {
            answer[i] = nums[i-1]*answer[i-1];
        }
        int fla = 1;
        for (int i = len-1; i >= 0 ; i--) {
            answer[i] = fla*answer[i];
            fla *= nums[i];
        }
        return answer;
    }
}
