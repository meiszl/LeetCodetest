package leetCodeTest;

public class 寻找峰值 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1,3,5,6,4};
        int peakElement = findPeakElement(nums);
        System.out.println("peakElement = " + peakElement);
    }

    /**
     * 二分查找
     * @param nums
     * @return
     */
    public static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left < right){
            mid = (left + right) >>1;
            System.out.println("mid = " + mid);
            if (nums[mid] < nums[mid + 1]){
                left = mid + 1;
            }else if (nums[mid] > nums[mid + 1]){
                right = mid;
            }
        }
        return left;
    }
}
