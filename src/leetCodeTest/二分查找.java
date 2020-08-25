package leetCodeTest;

public class 二分查找 {
    public static void main(String[] args) {
        int[] nums = new int[]{5};
        int target = 5;
        int search = search(nums, target);
        System.out.println(search);
    }
    public static int search(int[] nums, int target) {
        int left = 0,right = nums.length - 1;
        int mid;
        while (left <= right){
            mid = (left + right)>>>1;
            if (nums[mid] < target){
                left = mid + 1;
            }else if (nums[mid] > target){
                right = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
