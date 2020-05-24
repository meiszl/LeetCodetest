package leetCodeTest;

import java.util.ArrayList;
import java.util.List;

public class 组合总和 {
    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,5,10,4};
        int target = 8;
        List<List<Integer>> lists = combinationSum(candidates, target);
        System.out.println("lists = " + lists);
    }
    private static List<List<Integer>> res;
    private static int[] candi;
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        candi = candidates;
        find(0,target,new ArrayList<>());
        return res;
    }
    public static void find(int i,int target,List<Integer> list){
        if (target < 0)
            return;
        if (target == 0){
            res.add(list);
            return;
        }
        for (int j = i; j < candi.length; j++) {
            if (target < candi[j]) continue;
            list.add(candi[j]);
            find(j,target - candi[j],new ArrayList<>(list));
            list.remove(list.size()-1);
        }
    }
}
