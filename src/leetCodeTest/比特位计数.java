package leetCodeTest;

import java.util.Arrays;

public class 比特位计数 {
    public static void main(String[] args) {
        int num = 5;
        int[] ints = countBits(num);
        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));
    }

    /**
     * 暴力法。
     * @param num
     * @return
     */
//    public static int[] countBits(int num) {
//        int[] res = new int[num+1];
//        int count,tem;
//        for (int i = 0; i < res.length; i++) {
//            count = 0;
//            tem = i;
//            while (tem != 0){
//                count += tem&1;
//                tem = tem >>> 1;
//            }
//            res[i] = count;
//        }
//        return res;
//    }
    /**
     * 规划法
     * 详解：https://leetcode-cn.com/problems/counting-bits/solution/hen-qing-xi-de-si-lu-by-duadua/
     */
    public static int[] countBits(int num) {
        int[] sum = new int[num + 1];
        for (int i = 0; i < sum.length; i++) {
            if ((i&1) == 1){
                sum[i] = sum[i-1]+1;
            }else {
                sum[i] = sum[i/2];
            }
        }
        return sum;
    }
}
