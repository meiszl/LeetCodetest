package leetCodeTest;

public class 在排序数组中查找数字 {
    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 7;
        int search = search(nums, target);
        System.out.println("search = " + search);
    }
    public static int search(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target-1);
    }
    public static int helper(int[] nums,int target){
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return left;
    }
}
