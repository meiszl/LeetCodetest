package leetCodeTest;

import java.util.Arrays;

public class 在排序数组中查找元素第一个与最后一个位置 {
    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 8;
        int[] ints = searchRange(nums, target);
        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));
    }

    /**
     * 二分查找+中心扩散，超时
     * @param nums
     * @param target
     * @return
     */
//    public static int[] searchRange(int[] nums, int target) {
//        if (nums == null || nums.length == 0) return new int[]{-1,-1};
//        int left = 0;
//        int right = nums.length -1;
//        int mid = (right + left) >> 1;
//        int temp = mid;
//        int[] res = new int[2];
//        while (true){
//            if (nums[mid] != target){
//                mid = (right + left) >> 1;
//                if (left > right){
//                    res[0] = -1;
//                    res[1] = -1;
//                    return res;
//                }
//                System.out.println("mid = " + mid);
//                if (nums[mid] < target){
//                    left = mid + 1;
//                } else if (nums[mid] > target){
//                    right = mid - 1;
//                }
//                temp = mid;
//            }else {
//                if (temp - 1 >= 0 && mid + 1 < nums.length){
//                    if (nums[temp - 1] == target){
//                        temp--;
//                    }
//                    if (nums[mid+1]==target){
//                        mid++;
//                    }
//                }else if (temp-1<0&&mid+1<nums.length){
//                    if (nums[mid+1]==target){
//                        mid++;
//                    }
//                }else if (temp-1>=0&&mid+1>=nums.length){
//                    if (nums[temp - 1] == target){
//                        temp--;
//                    }
//                }else {
//                    res[0] = temp;
//                    res[1] = mid;
//                    return res;
//                }
//
//            }
//        }
//    }
    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1,-1};
        int[] res = new int[2];
        int leftBound = left_bound(nums, target);
        int rightBound = right_bound(nums, target);
        res[0] = leftBound;
        res[1] = rightBound;
        return res;
    }

    /**
     * 二分查找左边界。
     * @param nums
     * @param target
     * @return
     */
    public static int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，收缩左侧边界
                right = mid - 1;
            }
        }
        // 最后要检查 left 越界的情况
        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }

    /**
     * 二分查找右边界。
     * @param nums
     * @param target
     * @return
     */
    public static int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，收缩右侧边界
                left = mid + 1;
            }
        }
        // 最后要检查 right 越界的情况
        if (right < 0 || nums[right] != target)
            return -1;
        return right;
    }

}
