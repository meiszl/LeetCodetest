package leetCodeTest;

import java.util.Arrays;

public class 最小的k个数 {
    public static void main(String[] args) {
        int arr[] = new int[]{3,2,1};
        int k = 1;
        final int[] leastNumbers = getLeastNumbers(arr, k);
        System.out.println("leastNumbers = " + Arrays.toString(leastNumbers));
    }

    /**
     * 排序取出前k位数组成新数组
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int i;
        int[] result = new int[k];
        for (i=0;i<k;i++){
            result[i] = arr[i];
        }
        return result;
    }
}
