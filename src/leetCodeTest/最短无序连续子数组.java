package leetCodeTest;

public class 最短无序连续子数组 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 6, 4, 8, 10, 9, 15};
        int unsortedSubarray = findUnsortedSubarray(nums);
        System.out.println("unsortedSubarray = " + unsortedSubarray);
    }
    public static int findUnsortedSubarray(int[] nums) {
        if (nums == null||nums.length == 0) return 0;
        int i = 1,start = 0,end = 0;
        while (i<nums.length&&nums[i] <= nums[i-1]){
            i++;
        }
        if (i == nums.length - 1){
            return 0;
        }else {
            start = i-1;
        }
        for (;i<nums.length;i++){
            if (nums[i] <= nums[i-1]){
                end = i;
            }
        }
        return end - start;
    }
}
