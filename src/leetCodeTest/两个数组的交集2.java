package leetCodeTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class 两个数组的交集2 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{21,47,80,4,3,24,87,12,22,11,48,6,89,80,74,71,74,55,58,56,4,98,40,66,49,53,62,27,3,66,78,24,48,69,88,12,80,63,98,65,46,35,72,5,64,72,7,29,37,3,2,75,44,93,79,78,13,39,85,26,15,41,87,47,29,93,41,74,6,48,17,89,27,61,2,68,99,57,45,73,25,33,38,32,58};
        int[] nums2 = new int[]{1,39,6,81,85,10,38,22,0,89,57,93,58,69,65,80,84,24,27,54,37,36,26,88,2,7,24,36,51,5,74,57,45,56,55,67,25,33,78,49,16,79,74,80,36,27,89,49,64,73,96,60,92,31,98,72,22,31,0,93,70,87,80,66,75,69,81,52,94,90,51,90,74,36,58,38,50,9,64,55,4,21,49,60,65,47,67,8,38,83};
        int[] intersect = intersect(nums1, nums2);
        System.out.println("intersect = " + Arrays.toString(intersect));
    }
    /**
     * 暴力查询方法与排序+二分查找方法
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> numlist = new ArrayList();
        int i,j;
        for (i=0;i< nums2.length;i++){
            numlist.add(nums2[i]);
        }
        List<Integer> res = new ArrayList();
        for (i=0;i<nums1.length;i++) {
            int low = 0;
            int high = nums2.length-1;
            /**
             * 首先排序，然后使用二分查找来进行查询。
             * 此处注意在查询时不能破坏原顺序规则否则会查询失败。
             */
            while (high >= low){
                int middle = (low + high) / 2; //初始化中间位置的值
//                if (numlist.get(middle) > nums1[i]) {
                if (nums2[middle] > nums1[i]) {
                    high = middle-1;
//                } else if (numlist.get(middle) < nums1[i]) {
                } else if (nums2[middle] < nums1[i]) {
                    low = middle+1;
                } else {
                    /**
                     * 此处可以将原数组转换为list。
                     * 然后使用list.remove删除元素来保持原数组顺序
                     */
//                    res.add(numlist.get(middle));
//                    numlist.remove(middle);
//                    break;
                    /**
                     * 或者直接使用Arrays自带的排序来保持顺序
                     */
                    res.add(nums2[middle]);
                    nums2[middle] = -1;
                    Arrays.sort(nums2);
                    break;
                }
            }
            /**
             * 暴力循环对比每一个数
             */
//            for (j = 0; j < nums2.length; j++)
//                if (nums1[i] == nums2[j]) {
//                    res.add(nums1[i]);
//                    nums2[j] = -1;
//                    break;
//                }
        }
        int[] re = new int[res.size()];
        for (i=0;i<re.length;i++){
            re[i] = res.get(i);
        }
        return re;
    }

}
