package leetCodeTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.stream.Collectors;

public class 数组中第k个最大元素 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        int k = 3;
        int kthLargest = findKthLargest(nums, k);
        System.out.println("kthLargest = " + kthLargest);
    }

    /**
     * 先排序在选择
     * @param nums
     * @param k
     * @return
     */
//    public static int findKthLargest(int[] nums, int k) {
//        Integer[] integers = Arrays.stream(nums).boxed().collect(Collectors.toList()).toArray(new Integer[0]);
//        Arrays.sort(integers,(o1,o2) -> o2 - o1);
//        return integers[k-1];
//    }

    /**
     * 堆选择法，建立一个长度为k的小顶堆，将nums中的元素放入，最终堆顶即为所求结果
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num : nums) {
            priorityQueue.add(num);
            if (priorityQueue.size() > k)
                priorityQueue.poll();
        }
        return priorityQueue.peek();
    }
    /**
     * 快速选择算法
     */
//    public static int findKthLargest(int[] nums, int k) {
//        return quickselect(0,nums.length - 1,nums.length - k,nums);
//    }
//    public static int quickselect(int left,int right,int k_smallest,int[] nums){
//        if (left == right)
//            return nums[left];
//        Random random = new Random();
//        int pivot_index = left + random.nextInt(right - left);
//        pivot_index = selectK(left,right,pivot_index,nums);
//        if (k_smallest == pivot_index)
//            return nums[k_smallest];
//        else if (k_smallest < pivot_index)
//            return quickselect(left,pivot_index - 1,k_smallest,nums);
//        return quickselect(pivot_index + 1,right,k_smallest,nums);
//    }
//    public static int selectK(int left,int right,int target,int[] nums){
//        int num = nums[target];
//        int i,temp;
//        swap(target,right,nums);
//        temp = left;
//        for (i=left;i<right;i++){
//            if (nums[i] < num){
//                swap(temp,i,nums);
//                temp++;
//            }
//        }
//        swap(right,temp,nums);
//        return temp;
//    }
//    public static void swap(int a,int b,int[] nums){
//        int temp = nums[a];
//        nums[a] = nums[b];
//        nums[b] = temp;
//    }
}
