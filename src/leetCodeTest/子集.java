package leetCodeTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 子集 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        List<List<Integer>> subsets = subsets(nums);
        System.out.println("subsets = " + subsets);
    }

    /**
     * 暴力解法
     * @param nums
     * @return
     */
//    public static List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> output = new ArrayList<>();
//        output.add(new ArrayList<Integer>());
//        for (int num : nums) {
//            List<List<Integer>> newSubsets = new ArrayList<>();
//            for (List<Integer> list : output) {
//                newSubsets.add(new ArrayList<Integer>(list){{add(num);}});
//            }
//            for (List<Integer> newSubset : newSubsets) {
//                output.add(newSubset);
//            }
//        }
//        return output;
//    }

    /**
     * 回溯解法
     * @param nums
     * @return
     */
    private static List<List<Integer>> res;
    private static int n,k;
    public static List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        n = nums.length;
        for (k=0;k<nums.length +1;k++){
            search(new ArrayList<Integer>(),0,nums);
        }
        return res;
    }
    public static void search(List<Integer> list,int start,int[] nums){
        if (list.size() == k){
            res.add(new ArrayList<>(list));
        }
        int i;
        for (i=start;i<n;i++){
            list.add(nums[i]);
            search(list,start+1,nums);
            list.remove(list.size() - 1);
        }
    }

}
