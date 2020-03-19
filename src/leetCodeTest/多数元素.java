package leetCodeTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class 多数元素 {
    public static void main(String[] args) {
        int nums[] = {2,2,1,1,1,2,2};
        final int i = majorityElement(nums);
        System.out.println("i = " + i);

    }

    /**
     * 候选人(cand_num)初始化为nums[0]，票数count初始化为1。
     * 当遇到与cand_num相同的数，则票数count = count + 1，否则票数count = count - 1。
     * 当票数count为0时，更换候选人，并将票数count重置为1。
     * 遍历完数组后，cand_num即为最终答案。
     *
     * 为何这行得通呢？
     * 投票法是遇到相同的则票数 + 1，遇到不同的则票数 - 1。
     * 且“多数元素”的个数> ⌊ n/2 ⌋，其余元素的个数总和<= ⌊ n/2 ⌋。
     * 因此“多数元素”的个数 - 其余元素的个数总和 的结果 肯定 >= 1。
     * 这就相当于每个“多数元素”和其他元素 两两相互抵消，抵消到最后肯定还剩余至少1个“多数元素”。
     *
     * 无论数组是1 2 1 2 1，亦或是1 2 2 1 1，总能得到正确的候选人。
     *
     * 作者：gfu
     * 链接：https://leetcode-cn.com/problems/majority-element/solution/3chong-fang-fa-by-gfu-2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        int cand_num = nums[0], count = 1;
        int i;
        for (i = 1; i < nums.length; ++i) {
            if (cand_num == nums[i])
                ++count;
            else {
                if (--count == 0) {
                    cand_num = nums[i];
                    count = 1;
                }
            }
        }
        return cand_num;

    }
    /**
     * 传统办法，使用容器存储计数得到出现次数最多的数字，然后返回。
     * @param nums
     * @return
     */
//    public static int majorityElement(int[] nums) {
//        Map<Integer,Integer> map = new HashMap();
//        int i;
//        for (i=0;i<nums.length;i++){
//            if (map.containsKey(nums[i])){
//                Integer o = map.get(nums[i]);
//                map.put(nums[i],++o);
//            }else {
//                map.put(nums[i],1);
//            }
//        }
//        Object[] keys = map.keySet().toArray();
//        int temp = 0;
//        int siz = 0;
//        for (i = 0;i<keys.length;i++){
//            if (map.get(keys[i]) > temp){
//                temp = map.get(keys[i]);
//                siz = (int)keys[i];
//            }
//        }
//        return siz;
//    }
}
