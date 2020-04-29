package util;

import java.util.Arrays;

public class MountainArray {
    private int[] nums;
    public MountainArray(int[] nums){
        this.nums = nums;
    }

    public int get(int index) {
        return nums[index];
    }
    public int length() {
        return nums.length;
    }
    public String toString(){
        return Arrays.toString(nums);
    }
}