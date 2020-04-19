package leetCodeTest;

import java.util.Arrays;

public class 盛最多水的容器 {
    public static void main(String[] args) {
        int[] height = new int[]{1,2};
        int i = maxArea(height);
        System.out.println("i = " + i);
    }

    /**
     * 每次计算当前位置与其余位置所能组成的最大盛水量，然后遍历一遍数组然后返回即可。
     * @param height
     * @return
     */
//    public static int maxArea(int[] height) {
//        if (height.length == 0|| height == null) return 0;
//        int sum = 0;
//        int i,j;
//        for (i=0;i<height.length;i++){
//            for (j=0;j<height.length;j++){
//                if (i!=j){
//                    int len = height[i] <= height[j] ? height[i]:height[j];
//                    sum = Math.max(sum,Math.abs(i - j) * len);
//                }
//            }
//        }
//        System.out.println("Arrays.toString(sum) = " + sum);
//        return sum;
//    }

    /**
     * 双指针算法，从数组两侧同时遍历
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        if (height.length == 0|| height == null) return 0;
        int left = 0;
        int right = height.length - 1;
        int sum = 0;
        int len;
        while (left < right){
            len = Math.min(height[left],height[right]);
            sum = Math.max(sum,(right - left)*len);
            if (height[left] <= height[right]){
                left++;
            }else {
                right--;
            }
        }
        return sum;
    }
}
