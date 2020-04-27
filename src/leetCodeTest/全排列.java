package leetCodeTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 全排列 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> permute = permute(nums);
        for (List<Integer> list : permute) {
            System.out.println(list);
        }
    }
    private static List<List<Integer>> lists = new LinkedList<>();
    public static List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return lists;
        findAllnums(nums,new LinkedList<Integer>());
        return lists;
    }
    public static void findAllnums(int[] nums,LinkedList<Integer> list){
        int i;
        if (list.size() == nums.length){
            lists.add(new LinkedList<>(list));
        }
        for (i=0;i<nums.length;i++){
            if (list.contains(nums[i]))
                continue;
            list.add(nums[i]);
            findAllnums(nums, list);
            list.removeLast();
        }
    }

}
