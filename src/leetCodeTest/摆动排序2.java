package leetCodeTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 摆动排序2 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 1, 1, 6, 4,4};
        wiggleSort(nums);
        System.out.println("Arrays.toString(nums) = " + Arrays.toString(nums));
    }
    public static void wiggleSort(int[] nums) {
        List<Integer> low = new ArrayList<>();
        List<Integer> high = new ArrayList<>();
        int lowsize;
        int highsize = nums.length/2;
        if (nums.length %2 ==0) {
            lowsize = nums.length/2;
        } else {
            lowsize = nums.length/2+1;
        }
        Arrays.sort(nums);
        for (int i = 0; i < lowsize; i++) {
            low.add(nums[i]);
        }
        for (int i = lowsize,j=0; i < nums.length; i++,j++) {
            high.add(nums[i]);
        }
        int i=0,j=0,coun = 1;
        Collections.reverse(low);
        Collections.reverse(high);
        while (i<lowsize||j<highsize){
            if (coun%2 != 0)
                nums[coun-1] = low.get(i++);
            else
                nums[coun-1] = high.get(j++);
            coun++;
        }
    }
}
