package leetCodeTest;

import java.util.Arrays;
import java.util.HashSet;

public class 缺失的第一个正数 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,2,2,1,1,4,5};
        int i = firstMissingPositive(nums);
        System.out.println("i = " + i);
    }

    /**
     * 先排序在进行去重判断即可得到正确答案。
     * @param nums
     * @return
     */
//    public static int firstMissingPositive(int[] nums) {
//        int[] temp = new int[nums.length];
////        mergeSort(nums,0,nums.length - 1,temp); //归并排序
//        Arrays.sort(nums);
//        int fl = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] > 0){
//                fl = i;
//                break;
//            }
//        }
//        int co = 1;
//        HashSet hashSet = new HashSet();
//        for (int i = fl;i<nums.length;i++){
//            if (nums[i] == co&& !hashSet.contains(nums[i])){
//                hashSet.add(nums[i]);
//                co++;
//            }
//        }
//        return co;
//    }
//    public static void mergeSort(int[] nums,int low,int high,int[] temp){
//        int mid = (low + high) >> 1;
//        if (low < high){
//            mergeSort(nums,low,mid,temp);
//            mergeSort(nums,mid + 1,high,temp);
//            if (nums[mid] > nums[mid + 1])
//                merge(nums,low,high,mid,temp);
//        }
//    }
//    public static void merge(int[] nums,int low,int high,int mid,int[] temp){
//
//        int p1 = low,p2 = mid + 1,k =low;
//        while (p1 <= mid && p2 <= high){
//            if (nums[p1]<=nums[p2])
//                temp[k++] = nums[p1++];
//            else
//                temp[k++] = nums[p2++];
//        }
//        while (p1 <= mid) temp[k++] = nums[p1++];
//        while (p2 <= high) temp[k++] = nums[p2++];
//        for (int i =low;i<=high;i++)
//            nums[i] = temp[i];
//    }

    /**
     * 索引表方法，使用数组本身。
     * 思路详见：
     * https://leetcode-cn.com/problems/first-missing-positive/solution/que-shi-de-di-yi-ge-zheng-shu-by-leetcode/
     */
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int condation = 0;
        int i;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] == 1){
                condation++;
                break;
            }
        }
        if (condation == 0)
            return 1;
        //nums = [1]的情况
        if (n==1)
            return 2;
        //将数组中小于0，等于0，以及大于n的都变成1
        for (i=0;i<nums.length;i++){
            if (nums[i] <= 0 || nums[i] > n){
                nums[i] = 1;
            }
        }

        //按数组中的元素将索引位置变为负数，例如，[1,1,1,2] -> [1,-1,-1,1,2],0下标存储n位置的正负，
        // 然后根据每一位的正负进行丢失元素判断
        for (i=0;i<nums.length;i++){
            int a = Math.abs(nums[i]);
            if (a==n)
                nums[0] = -Math.abs(nums[0]);
            else
                nums[a] = -Math.abs(nums[a]);
        }

        for (i=1;i<nums.length;i++){
            if (nums[i] > 0)
                return i;
        }
        if (nums[0] > 0)
            return n;
        return n+1;
    }

}
