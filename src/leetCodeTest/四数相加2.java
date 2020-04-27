package leetCodeTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 四数相加2 {
    public static void main(String[] args) {
        int[] A,B,C,D;
        A = new int[]{1,2};
        B = new int[]{-2,-1};
        C = new int[]{-1,2};
        D = new int[]{0,2};
        int i = fourSumCount(A, B, C, D);
        System.out.println("i = " + i);
    }
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int i,j,res = 0;
        Map<Integer,Integer> map = new HashMap();
        for (i=0;i<A.length;i++){
            for (j=0;j<B.length;j++){
                if (map.containsKey(A[i] + B[j]))
                    map.put(A[i] + B[j],map.get(A[i] + B[j]) + 1);
                else
                    map.put(A[i] + B[j],1);
            }
        }
        for (i=0;i<C.length;i++){
            for (j=0;j<D.length;j++){
                int sum = -(C[i] + D[j]);
                if (map.containsKey(sum))
                    res += map.get(sum);
            }
        }
        return res;
    }
}
