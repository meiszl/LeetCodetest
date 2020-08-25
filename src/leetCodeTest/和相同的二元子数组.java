package leetCodeTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class 和相同的二元子数组 {
    public static void main(String[] args) {
        int[] a = new int[]{1,0,1,0,1};
        int s = 2;
        int i = numSubarraysWithSum(a, s);
        System.out.println(i);
    }
    public static int numSubarraysWithSum(int[] A, int S) {
        if (A.length == 0)
            return 0;
        int[] sum = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            sum[i+1] = sum[i] + A[i];
        }
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int res = 0;
        for (int i : sum) {
            res += hashMap.getOrDefault(i,0);
            hashMap.put(i+S,hashMap.getOrDefault(i+S,0) + 1);
        }
        return res;
    }
}
