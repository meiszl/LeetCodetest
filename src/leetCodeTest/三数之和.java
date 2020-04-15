package leetCodeTest;

import java.util.*;

public class 三数之和 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println("lists = " + lists);
    }

    /**
     * 双指针法，首先对数组进行排序，然后从i=0开始遍历，并且定义两个指针，使指针指向L=i+1与R=length-1的两个位置，
     * 然后计算i,L,R三个位置的数字之和，如果等于0则将三个数导入List中，否则就执行L++与R--，
     * 并且判断L++位置的值是否与L位置相等，R--的位置的值是否与R相等，如果相等就分别向右向左移动指针直到不相等（
     * 为了过滤掉重复的判断数据，因为同样的数值加上同一数组中的其余两个数值才会等于0，如果重复判断同样的数就会
     * 得到相同的结果）。
     * 详细可以参考：https://leetcode-cn.com/problems/3sum/solution/3sumpai-xu-shuang-zhi-zhen-yi-dong-by-jyd/
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList();
        Arrays.sort(nums);
        System.out.println("Arrays.toString(nums) = " + Arrays.toString(nums));
        int i;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] > 0) return lists;
            if (i>0 && nums[i] == nums[i-1]) continue;
            int curr = nums[i];
            int L = i+1,R = nums.length-1;
            while (L < R){
                int tmp = curr + nums[L] + nums[R];
                if (tmp == 0){
                    List<Integer> list = new ArrayList();
                    list.add(curr);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    lists.add(list);
                    while (L<R && nums[L+1] == nums[L]) ++L;
                    while (L<R && nums[R-1] == nums[R]) --R;
                    ++L;
                    --R;
                }else if (tmp < 0){
                    ++L;
                }else {
                    --R;
                }
            }
        }
        return lists;
    }

}
