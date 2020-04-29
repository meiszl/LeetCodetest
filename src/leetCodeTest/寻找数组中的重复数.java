package leetCodeTest;

import java.util.HashSet;

public class 寻找数组中的重复数 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,4};
        int duplicate = findDuplicate(nums);
        System.out.println("duplicate = " + duplicate);
    }

    /**
     * 集合法
     * @param nums
     * @return
     */
//    public static int findDuplicate(int[] nums) {
//        HashSet<Integer> hashSet = new HashSet();
//        for (int num : nums) {
//            if (hashSet.contains(num))
//                return num;
//            else
//                hashSet.add(num);
//        }
//        return -1;
//    }
    /**
     * 快慢指针筛选法，1-n的数组中必然存在循环链，通过快慢指针可以快速的找到循环的节点
     */
    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow!=fast);
        slow = nums[0];
        while (slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
