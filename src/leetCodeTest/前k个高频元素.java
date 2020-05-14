package leetCodeTest;

import java.util.*;

public class 前k个高频元素 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,2,2,2,1,1,1,1,1};
        int k = 1;
        int[] ints = topKFrequent(nums, k);
        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));
    }

    /**
     * 对HashMap进行排序
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num,hashMap.getOrDefault(num,0)+1);
        }
        Set<Map.Entry<Integer, Integer>> entries = hashMap.entrySet();
        int[] res = new int[k];
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(entries);
        list.sort((o1, o2) -> o2.getValue()-o1.getValue());
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i).getKey();
        }
        return res;
    }
}
