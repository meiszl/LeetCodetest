package leetCodeTest;

public class 寻找两个有序数组的中位数 {
    public static void main(String[] args) {
        int[] num1 = new int[]{};
        int[] num2 = new int[]{1};
        double medianSortedArrays = findMedianSortedArrays(num1, num2);
        System.out.println("medianSortedArrays = " + medianSortedArrays);
    }

    /**
     * TODO 待做
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double nummed1 = 0.0;
        double nummed2 = 0.0;
        if (nums1.length != 0)
        nummed1 = nums1.length%2 == 0 ?
                (((double)nums1[(nums1.length-1)/2])+((double)nums1[(nums1.length-1)/2+1]))/2 : nums1[Math.round((nums1.length-1)/2)];
        if (nums2.length != 0)
        nummed2 = nums2.length%2 == 0 ?
                (((double)nums2[(nums2.length-1)/2])+((double)nums2[(nums2.length-1)/2+1]))/2 : nums2[Math.round((nums2.length-1)/2)];
        if (nummed1 == 0.0)
            return nummed2;
        if (nummed2 == 0.0)
            return nummed1;
        return (nummed1 + nummed2)/2;
    }
}
