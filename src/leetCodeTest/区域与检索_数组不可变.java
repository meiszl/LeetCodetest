package leetCodeTest;

public class 区域与检索_数组不可变 {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0,5));
    }
}

class NumArray {
    private int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        if (i>j||i<0||j>=nums.length)
            return 0;
        int count = 0;
        for (;i<=j;i++){
            count += nums[i];
        }
        return count;
    }
}