package leetCodeTest;

import java.util.Arrays;

public class 合并两个有序数组 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{1};
        int m =0;
        int n =1;
        merge(nums1,m,nums2,n);
        System.out.println("Arrays.toString(nums1) = " + Arrays.toString(nums1));
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = nums1.clone();
        int i=0,j=0,fl = 0;
        while (i<m&&j<n){
            if (temp[i] > nums2[j]){
                nums1[fl++] = nums2[j++];
            }else {
                nums1[fl++] = temp[i++];
            }
        }
        while (i < m) nums1[fl++] = temp[i++];
        while (j<n) nums1[fl++] = nums2[j++];
    }
}
