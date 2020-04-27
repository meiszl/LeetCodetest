package leetCodeTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class 计算右侧小于当前元素的个数 {
    public static void main(String[] args) {
        int[] nums = new int[]{5,2,6,1};
        List<Integer> list = countSmaller(nums);
        System.out.println("list = " + list);
    }
    public static List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] idx = new int[n];
        int[] res = new int[n];
        for (int i = 0; i < idx.length; i++) {
            idx[i] = i;
            res[i] = 0;
        }
        mergeso(nums,0,n-1,idx,idx.clone(),res);
        List<Integer> list = Arrays.stream(res).boxed().collect(Collectors.toList());
        return list;
    }

    private static void mergeso(int[] nums, int low, int hig, int[] idx, int[] aux, int[] res) {
        int nRemaining = hig - low + 1;
        if (nRemaining < 2) return;
        int mid = low + ((hig - low) >>> 1);
        mergeso(nums, low, mid, aux, idx, res);
        mergeso(nums, mid + 1, hig, aux, idx, res);
        if (nums[aux[mid]] <= nums[aux[mid + 1]]){
            System.arraycopy(aux,low,idx,low,nRemaining);
            return;
        }
        merge(nums,low,mid,hig,idx,aux,res);
    }

    private static void merge(int[] nums, int low, int mid, int hig, int[] idx, int[] aux, int[] res) {
        int i = low,j = mid + 1;
        for (int k = low; k <= hig; k++) {
            if (i>mid){
                idx[k] = aux[j++];
            }else if (j>hig){
                res[aux[i]] += j-mid-1;
                idx[k] = aux[i++];
            }else if (nums[aux[i]] > nums[aux[j]]){
                idx[k] = aux[j++];
            }else {
                res[aux[i]] += j-mid-1;
                idx[k] = aux[i++];
            }
        }
    }
//    public static List<Integer> merge(int[] nums) {
//        int n = nums.length;
//        int[] idx = new int[n];
//        // 使用位置索引，原始位置不变
//        Integer[] res = new Integer[n];
//        for (int i = 0; i < n; i++) {
//            idx[i] = i;
//            res[i] = 0;
//        }
//        // 直接使用拷贝，节省拷贝时间
//        mergeSort(nums, 0, n - 1, idx, idx.clone(), res);
//        return Arrays.asList(res);
//    }
//    // 使用同一的辅助数组，避免频繁创建、销毁
//    private static void mergeSort(int[] nums, int low, int hig, int[] idx, int[] aux, Integer[] res) {
//        int nRemaining = hig - low + 1;
//        if (nRemaining < 2) return;
//        int mid = low + ((hig - low) >> 1);
//        mergeSort(nums, low, mid, aux, idx, res);
//        mergeSort(nums, mid + 1, hig, aux, idx, res);
//        // 如果已经有序，则无需归并。
//        if (nums[aux[mid]] <= nums[aux[mid + 1]]) {
//            System.arraycopy(aux, low, idx, low, nRemaining);
//            return;
//        }
//        merge(nums, low, mid, hig, idx, aux, res);
//    }
//
//    private static void merge(int[] nums, int low, int mid, int hig, int[] idx, int[] aux, Integer[] res) {
//        int i = low, j = mid + 1;
//        for (int k = low; k <= hig; k++) {
//            if (i > mid) {
//                idx[k] = aux[j++];
//            } else if (j > hig) {
//                // 这里
//                res[aux[i]] += j - mid - 1;
//                idx[k] = aux[i++];
//            } else if (nums[aux[i]] > nums[aux[j]]) {
//                // 如果统计的是总交换次数，那么应该在这里+mid-i+1
//                idx[k] = aux[j++];
//            } else {
//                // 这里
//                res[aux[i]] += j - mid - 1;
//                idx[k] = aux[i++];
//            }
//        }
//    }
}
