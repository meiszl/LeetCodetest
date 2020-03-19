package leetCodeTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCodeTest两数之和 {
    public static void main(String[] args) {
        int a[] = {2,7,11,15};
        int re[] = twoSum(a,9);
        System.out.println(Arrays.toString(re));
    }

    /**
     * 算法思路：利用空间换时间的概念，将目标和转换为Map集合中的差值
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int i;
        Map map = new HashMap<Integer,Integer>();
        //计算目标和与数组中每一个元素的差
        for (i=0;i<nums.length;i++){
            int increasement = target - nums[i];
            //判断map集合中是否含有该差值，如果有就将该差值的下标与当前数组元素的下标一同返回
            if (map.containsKey(increasement)){
                return new int[]{(int) map.get(increasement),i};
            }
            //将当前元素作为key，下标作为值存入map集合中
            map.put(nums[i],i);
        }
        //计算结束如果未返回下标数组就抛出异常
        throw new IllegalArgumentException("No two sum solution");
    }
}
