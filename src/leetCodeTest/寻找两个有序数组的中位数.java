package leetCodeTest;


public class 寻找两个有序数组的中位数 {
    public static void main(String[] args) {
        int[] num1 = new int[]{1,2};
        int[] num2 = new int[]{3,4};
        double medianSortedArrays = findMedianSortedArrays(num1, num2);
        System.out.println("medianSortedArrays = " + medianSortedArrays);
    }

    /**
     * 合并成一个数组，然后排序求中位数即可。
     * @param nums1
     * @param nums2
     * @return
     */
//    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int[] res = new int[nums1.length + nums2.length];
//        int i;
//        for (i = 0; i < nums1.length; i++) {
//            res[i] = nums1[i];
//        }
//        int temp = i;
//        for (i=0;i<nums2.length;i++){
//            res[temp++] = nums2[i];
//        }
//        Arrays.sort(res);
//        if (res.length%2 == 0){
//            double re = (Double.valueOf(res[res.length / 2]) + Double.valueOf(res[res.length / 2 - 1]))/2;
//            return re;
//        }else {
//            Double re = Double.valueOf(res[res.length / 2]);
//            return re;
//        }
//    }

    /**
     * 递归法，双百
     * @param A
     * @param B
     * @return
     */
    public static double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
